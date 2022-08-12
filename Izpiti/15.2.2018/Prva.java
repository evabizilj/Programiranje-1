
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

public class Prva {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    //=========================================================================
    // V vseh testnih primerih velja t.length >= 2, t.length <= 2000 in 
    // t.length % 2 == 0.
    //=========================================================================

    public static boolean jePodvojena(int[] t) {
        int polovica = t.length / 2;
        for (int i = 0; i < polovica; i++) {
            if (t[i] != t[i + polovica])
                return false;
        }
        return true;
    }

    //=========================================================================
    // V vseh testnih primerih velja:
    // -- d >= 1
    // -- "stevilo vrstic tabele t je med 1 in 200
    // -- "stevilo stolpcev tabele t je med 1 in 200
    //
    // V testnih primerih J6 in S26--S30 ima tabela eno samo vrstico.
    // V testnih primerih J7 in S31--S35 ima tabela en sam stolpec.
    //=========================================================================

    public static int[] steviloDeljivih(int[][] t, int d) {
        int[] stolpci = new int[t[0].length];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j] % d == 0)
                    stolpci[j]++;
            }
        }
        return stolpci;
    }
}
