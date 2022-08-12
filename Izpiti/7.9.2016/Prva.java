
import java.util.*;

public class Prva {

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 1 <= n <= 10^9 in 2 <= osnova <= 10^9.
    //-------------------------------------------------------------------------
    public static boolean jePotenca(int n, int osnova) { 
      int zmnozek = 1;
      while (zmnozek < n) {
        zmnozek *= osnova;
      }
      if (zmnozek == n)
        return true;
      return false;
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 1 <= t.length <= 1000.
    //-------------------------------------------------------------------------
    public static int zadnjiManjsi(int[] t, int n) {
      int index = 0;
      for (int i = 0; i < t.length; i++) {
        if (t[i] >= n) 
          return i - 1;
      }
      return t.length - 1;
    }

    //-------------------------------------------------------------------------
    // V vseh testnih primerih velja 1 <= a.length <= 100 in
    // 1 <= b.length <= 100.
    //-------------------------------------------------------------------------
    public static int[][] zmnozki(int[] a, int[] b) {
      int[][] array = new int[a.length][b.length];
      for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
          array[i][j] = a[i] * b[j];
        }
      }
      return array;
    }
}
