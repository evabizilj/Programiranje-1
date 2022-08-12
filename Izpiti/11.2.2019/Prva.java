
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

import java.util.Arrays;

public class Prva {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    //=========================================================================
    // V vseh testnih primerih velja n > 0 in n < 1 000 000 000.
    //=========================================================================

    public static int povecajPrvo(int n) {
        // popravite / dopolnite ...
        int stevilo = n;
        int steviloStevk = 0;
        int produkt = 1;
        while (stevilo > 0) {
            steviloStevk++;
            stevilo /= 10;
        }
        for (int i = 0; i < steviloStevk - 1; i++) {
            produkt *= 10;
        }
        return n + produkt;
    }

    //=========================================================================
    // V vseh testnih primerih je tabela t pravokotna, "stevilo vrstic in
    // "stevilo stolpcev pa je na intervalu [1, 100].
    //
    // V testnih primerih J6 in S26--S30 je "stevilo vrstic enako 1, v
    // primerih J7 in S31--S35 pa 2.
    //=========================================================================

    public static boolean enakiStolpci(int[][] t) {
        int [] vrstice = new int[t.length];
        int element = 0;

        for (int i = 0; i < t.length; i++) {
            element = t[i][0];
            for (int j = 0; j < t[i].length; j++) {
                if (element != t[i][j])
                    return false;
            }
        }
        return true;
    }
}
