
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

import java.util.Arrays;

public class Druga {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    //=========================================================================
    public static class Stih {
        private int zacetnik;
        private int[] karte;

        public Stih(int zacetnik, int[] karte) {
            this.zacetnik = zacetnik;
            this.karte = karte;
        }

        public int vrednost() {
            // popravite / dopolnite ...
            return -999;
        }

        public int dobitnik() {
            // popravite / dopolnite ...
            return -999;
        }

        // po potrebi dodajte svoje metode ...
    }

    public static class Partija {
        private int stIgralcev;
        private Stih[] stihi;

        public Partija(int stIgralcev, Stih[] stihi) {
            this.stIgralcev = stIgralcev;
            this.stihi = stihi;
        }

        public int kdoJeVrgel(int karta) {
            // popravite / dopolnite ...
            return -999;
        }

        public int[] tocke() {
            // popravite / dopolnite ...
            return null;
        }

        // po potrebi dodajte svoje metode ...
    }
}
