
// 
// (v prej"snji vrstici dopi"site va"so vpisno "stevilko)

public class Prva {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    //=========================================================================
    // V vseh testnih primerih velja n > 0.
    //=========================================================================

    public static int alternirajocaVsota(int n) {
        // popravite / dopolnite ...
        int stevka = 0;
        int stevilo = 0;
        int vsotaStevk = 0;
        int sodo = 0;
        int liho = 0;
        while (n > 0) {
            stevka = n % 10;
            stevilo = stevilo * 10 + stevka;
            n /= 10; 
            vsotaStevk++;
            if (vsotaStevk % 2 == 0)
                sodo -= stevka;
            else
                liho += stevka;
        }
        return sodo + liho;
    }

    //=========================================================================
    // V vseh testnih primerih velja:
    // -- "stevilo vrstic tabele t je med 1 in 500
    // -- "stevilo stolpcev tabele t je med 1 in 500
    //
    // V testnih primerih J6--J7 in S26--S35 ima tabela en sam stolpec.
    //
    // V testnih primerih J6, J8, S26--S30 in S36--S40 je v vsakem stolpcu
    // _natanko_ ena zvezdica.
    //=========================================================================

    public static int[] polozajiZvezdic(char[][] t) {
        int stStolpcev = 0;
        for (int i = 0; i < t.length; i++) {
            stStolpcev = t[i].length;
        }
        int[] tabela = new int[stStolpcev];
        int[] stolpec = new int[stStolpcev];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j] == '*') {
                    tabela[j] = i;
                    stolpec[j]++;
                }
            }
        }
        for (int i = 0; i < stolpec.length; i++) {
            if (stolpec[i] == 0)
                tabela[i] = -1;
        }
        return tabela;
    }
}

