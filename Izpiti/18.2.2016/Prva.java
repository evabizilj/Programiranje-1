
import java.util.*;

public class Prva {

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 2 <= n <= 10^4.
    //-------------------------------------------------------------------------
    public static int prviPraviDelitelj(int n) {
      int i = 2;
      while (i < n) {
        if (n % i == 0)
          return i;
        i++;
      }
      return i;
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 1 <= t.length <= 10^4.
    //-------------------------------------------------------------------------
    public static boolean uravnotezeno(boolean[] t) {
      int stTrue = 0;
      for (int i = 0; i < t.length; i++) {
        if (t[i])
          stTrue++;
      }
      return (stTrue == t.length - stTrue);
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 1 <= t.length <= 10^4.
    //-------------------------------------------------------------------------
    public static int[] rotacija(int[] t, int r) {
      int[] rezultat = new int[t.length];
      for (int i = 0; i < t.length; i++) 
        rezultat[((i + r) % t.length + t.length) % t.length] = t[i];
      return rezultat;
    }
  }