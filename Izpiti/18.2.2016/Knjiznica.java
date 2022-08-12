
import java.util.*;

public class Knjiznica {

  public static final int ST_IZVODOV_NA_NASLOV = 10;
  private int stClanov;
  private int stNaslovov;
  private int izposoja[][];
  private int zaloga[];

    // dopolnite ...

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 1 <= stClanov <= 100
    // in 1 <= stNaslovov <= 100.
    //-------------------------------------------------------------------------
    public Knjiznica(int stClanov, int stNaslovov) {
      this.stClanov = stClanov;
      this.stNaslovov = stNaslovov;
      this.izposoja = new int[stClanov][stNaslovov];
      this.zaloga = new int[stNaslovov];
      for (int i = 0; i < stNaslovov; i++) {
        zaloga[i] = ST_IZVODOV_NA_NASLOV;
      }
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 0 <= clan < "stevilo "clanov
    // in 0 <= naslov < "stevilo naslovov.
    //-------------------------------------------------------------------------
    public void posodi(int clan, int naslov) {
      if (this.zaloga[naslov] > 0) {
        this.izposoja[clan][naslov]++;
        this.zaloga[naslov]--;
      }
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 0 <= clan < "stevilo "clanov.
    //-------------------------------------------------------------------------
    public void pridobiNazaj(int clan) {
      for (int i = 0; i < this.izposoja[clan].length; i++) {
        this.zaloga[i] += this.izposoja[clan][i];
        this.izposoja[clan][i] = 0;
      }
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 0 <= naslov < "stevilo naslovov.
    //-------------------------------------------------------------------------
    public int naVoljo(int naslov) {
      return this.zaloga[naslov];
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 0 <= clan < "stevilo "clanov
    // in 0 <= naslov < "stevilo naslovov.
    //-------------------------------------------------------------------------
    public int posojeni(int clan, int naslov) {
      return this.izposoja[clan][naslov];
    }

    //-------------------------------------------------------------------------
    public int posojeni() {
      int posojeni = 0;
      for (int i = 0; i < this.izposoja.length; i++) {
        for (int j = 0; j < this.izposoja[i].length; j++) {
          posojeni += this.izposoja[i][j];
        }
      }
      return posojeni; 
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 0 <= naslov < "stevilo naslovov.
    //-------------------------------------------------------------------------
    public int najClan(int naslov) {
      int max = 0;
      int index = 0;
      for (int i = 0; i < this.izposoja.length; i++) {
          if (this.izposoja[i][naslov] > max) {
            max = this.izposoja[i][naslov];
            index = i;
          }
      }
      return index; 
    }
}
