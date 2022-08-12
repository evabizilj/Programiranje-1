
import java.util.*;

public class Druga {
  private static final int MAX_ST_RACUNOV = 100;

    // Po potrebi lahko dodate "se kak"sen stati"cen notranji razred (public
    // static class ...).  Stati"cen notranji razred se obna"sa enako kot
    // samostojen razred.

    public static class Racun {
      private String stevilka;
      private int stanje;
      private int stPologov;

      public Racun(String stevilka, int stanje) {
        this.stevilka = stevilka;
        this.stanje = stanje;
        this.stPologov = 0;
      }

      public String vrniStevilko() {
        return stevilka;
      }

      public int vrniStanje() {
        return this.stanje;
      }

      public void polozi(int znesek) {
        this.stanje += znesek;
        this.stPologov++;
      }

      public boolean dvigni(int znesek) {
        if (this.stanje < znesek) 
          return false;
        this.stanje -= znesek;
        return true;
      }

      public int vrniSteviloPologov() {
        return this.stPologov;
      }

    }

    public static class Banka {

        // po potrebi dodajte atribute in/ali metode ...

        private Racun[] racuni;
        private int stRacunov;



        //---------------------------------------------------------------------
        public Banka() {
          this.racuni = new Racun[MAX_ST_RACUNOV];
            // po potrebi dopolnite ...
        }

        //---------------------------------------------------------------------
        public void odpriRacun(String stRacuna) {
          Racun racun = new Racun(stRacuna, 0);
          this.racuni[this.stRacunov] = racun;
          this.stRacunov++;
        }

        //---------------------------------------------------------------------
        public int stanje(String stRacuna) {
          Racun racun = this.poisciRacun(stRacuna);
          return racun.vrniStanje();
        }

        private Racun poisciRacun(String stRacuna) {
          for (int i = 0; i < this.stRacunov; i++) {
            if (this.racuni[i].vrniStevilko().equals(stRacuna)) {
              return this.racuni[i];
            }
          }
          throw new RuntimeException(String.format("Ne najdem računa s številko %s ...", stRacuna));
        }

        //---------------------------------------------------------------------
        public void polozi(String stRacuna, int znesek) {
          Racun racun = this.poisciRacun(stRacuna);
          racun.polozi(znesek);
        }

        //---------------------------------------------------------------------
        public boolean dvigni(String stRacuna, int znesek) {
          Racun racun = this.poisciRacun(stRacuna);
          return racun.dvigni(znesek);
        }

        //---------------------------------------------------------------------
        public boolean prenesi(String izvor, String cilj, int zn) {
          if (this.dvigni(izvor, zn)) {
            this.polozi(cilj, zn);
            return true;
          }
          return false;
        }

        //---------------------------------------------------------------------
        public String najvecPologov() {
          int iNaj = 0;
          for (int i = 0; i < this.stRacunov; i++) {
            if (this.racuni[i].vrniSteviloPologov() > this.racuni[iNaj].vrniSteviloPologov()) {
              iNaj = i;
            }
          }
          return this.racuni[iNaj].vrniStevilko();
        }
    }
}
