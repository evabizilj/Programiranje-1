
import java.util.*;

public class Igra {

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 1 <= stStolpcev <= 1000.
    //-------------------------------------------------------------------------

    private final static int ST_VRSTIC = 10;
    private int stStolpcev;
    private int naPotezi; 
    private int[] zasedenost;
    private int[][] plosca;

    public Igra(int stStolpcev) {
      this.stStolpcev = stStolpcev;
      this.naPotezi = 1;
      this.zasedenost = new int[stStolpcev];
      this.plosca = new int[ST_VRSTIC][stStolpcev];
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 0 <= st < "stevilo stolpcev.
    //-------------------------------------------------------------------------
    public void spusti(int st) {
      this.plosca[this.zasedenost[st]][st] = this.naPotezi;
      this.zasedenost[st]++;
      if (this.naPotezi() == 1)
        this.naPotezi = 2;
      else 
        this.naPotezi = 1;
    }

    //-------------------------------------------------------------------------
    public int naPotezi() {
        return this.naPotezi;
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 0 <= st < "stevilo stolpcev.
    //-------------------------------------------------------------------------
    public int vStolpcu(int st) {
      return this.zasedenost[st];
    }
    

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 0 <= vr < 10.
    //-------------------------------------------------------------------------
    public int vVrstici(int vr) {
      int sum = 0;
      for (int i = 0; i < this.stStolpcev; i++) {
        if (this.plosca[vr][i] > 0)
          sum++;
      }
      return sum;
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja:
    //   1 <= igralec <= 2
    //   0 <= vr < 10
    //   n >= 1
    //-------------------------------------------------------------------------
    public boolean zaporedje(int igralec, int vr, int n) {
      int zaporedje = 0;
      for (int i = 0; i < this.stStolpcev; i++) {
        if (this.plosca[vr][i] == igralec) {
          zaporedje++;
          if (zaporedje == n)
            return true;
        }
        else
          zaporedje = 0;
      }
      return false;
    }
  }
         