
/**
 * NALOGA 1
 */

public class Park {

    /**
     * Naloga (a) -- vrne "stevilo prostih parkirnih mest na parkiri"s"cu.
     */
    public static int steviloProstih(boolean[][] p) {
      int stProstih = 0;
      for (int i = 0; i < p.length; i++) {
        for (int j = 0; j < p[i].length; j++) {
          if (p[i][j])
            stProstih++;
        }
      }
      return stProstih;
    }

    /**
     * Naloga (b) -- preveri, ali obstaja vrstica z vsaj k zaporednimi (!)
     * prostimi mesti.
     */
    public static boolean zaporedje(boolean[][] p, int k) {
      for (int i = 0; i < p.length; i++) {
        int stProstih = 0;
        for (int j = 0; j < p[i].length; j++) {
          if (p[i][j]) {
            stProstih++;
            if (stProstih >= k)
              return true;
          }
          else
            stProstih = 0;
        }
      }
      return false;
    }

    /**
     * Naloga (c) -- vrne "stevilo VSEH parkirnih mest v gara"zni hi"si.
     */
    public static int steviloMest(boolean[][][] g) {
      int stMest = 0;
      for (int i = 0; i < g.length; i++) {
        for (int j = 0; j < g[i].length; j++) {
          for (int k = 0; k < g[i][j].length; k++) {
            stMest++;
          }
        }
      }
      return stMest;
    }

    /**
     * Naloga (d) -- vrne indeks nadstropja z najve"c prostimi mesti.
     */
    public static int najboljProstoNadstropje(boolean[][][] g) {
      int max = 0;
      int index = 0;
      int[] zasedenostNadstropij = new int[g.length];
      for (int i = 0; i < g.length; i++) {
        for (int j = 0; j < g[i].length; j++) {
          for (int k = 0; k < g[i][j].length; k++) {
            if (g[i][j][k]) {
              zasedenostNadstropij[i]++;
            }
          }
        }
      }
      for (int i = 0; i < zasedenostNadstropij.length; i++) {
        if (max < zasedenostNadstropij[i]) {
          max = zasedenostNadstropij[i];
          index = i;
        }
      }
      return index;
    }
}

