
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

import java.util.Arrays;

public class Prva {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }
    

    //=========================================================================
    // V vseh testnih primerih velja a > 0 in b > 0, rezultat pa je manj"si od
    // 1 000 000 000.
    //=========================================================================

    public static int stakni(int a, int b) {
        int stevilo2 = b;
        int stStevk = 0;
        int produkt = 1;
        while (stevilo2 > 0) {
            stStevk++;
            stevilo2 /= 10;
        }
        for (int i = 0; i < stStevk; i++) {
            produkt *= 10;
        }
        return a * produkt + b;
    }

    //=========================================================================
    // V vseh testnih primerih je tabela t pravokotna, "stevilo vrstic in
    // "stevilo stolpcev pa je na intervalu [1, 100].
    //
    // V testnih primerih J6 in S26--S30 je "stevilo vrstic enako 2, v
    // primerih J7 in S31--S35 pa 3.
    //=========================================================================

    public static boolean vednoBoljRes(boolean[][] t) {
        int zdaj = 0;
        int prej = 0;
        for (int i = 0; i < t.length; i++) {
            // if (zdaj <= prej)
            //     return false;
            // prej = zdaj;
            // zdaj = 0;
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j])
                    zdaj++;
            }
        }
        return true;
    }
}