
public class Prva {

    //=========================================================================
    // V vseh testnih primerih velja n >= 1.
    //=========================================================================

    public static boolean deljivoZVsotoStevk(int n) {
      int stevilo = n;
      int vsota = 0;
      int stevka = 0;
      while (stevilo > 0) {
        stevka = stevilo % 10;
        vsota += stevka;
        stevilo /= 10;
      }
      if (n % vsota == 0)
        return true;
      return false;
    }

    //=========================================================================
    // V vseh testnih primerih je tabela t pravokotna.  Ima najmanj 1 in
    // najve"c 100 vrstic ter najmanj 1 in najve"c 100 stolpcev.
    //=========================================================================

    public static int negativnaVrstica(int[][] t) {
      int stolpci = 0;
      for (int i = 0; i < t.length; i++) {
        int sum = 0;
        for (int j = 0; j < t[i].length; j++) {
          stolpci = t[i].length + 1;
          if (t[i][j] < 0) {
            sum++;
          } 
        }
        if (sum + 1 == stolpci)
          return i;
      }
      return -1;
    }
  }
