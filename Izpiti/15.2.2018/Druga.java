
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

public class Druga {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    // po potrebi lahko dodate pomo"zne razrede ...

    //=========================================================================
    public static class Portal {

        // dodajte atribute in metode (po potrebi) ...
        private int stIgralcev;
        private int[] izid;
        private int[] igralec;
        private int[][][] partija;

        //---------------------------------------------------------------------
        // V vseh testnih primerih velja stIgralcev >= 2 in stIgralcev <= 100.
        //---------------------------------------------------------------------
        public Portal(int stIgralcev) {
            this.stIgralcev = stIgralcev;
            this.izid = new int[3];
            this.igralec = new int[stIgralcev];

            // dopolnite ...
        }

        //---------------------------------------------------------------------
        // V vseh testnih primerih velja beli >= 0, beli < stIgralcev,
        // crni >= 0, crni < stIgralcev in beli != crni.
        //---------------------------------------------------------------------
        public void zabeleziPartijo(int beli, int crni, int izid) {
            if (izid == 0) {
                this.igralec[beli]++;
                this.igralec[crni]++;
            }
            if (izid == 1) {
                this.igralec[beli] += 2;
            }
            if (izid == 2) {
                this.igralec[crni] += 2;
            }
            this.izid[izid]++;
            partija[beli][crni][izid]++;
        }

        //---------------------------------------------------------------------
        public int steviloRemijev() {
            return this.izid[0];
        }

        //---------------------------------------------------------------------
        // V vseh testnih primerih velja igralec >= 0 in igralec < stIgralcev.
        //---------------------------------------------------------------------
        public int tocke(int igralec) {
            return this.igralec[igralec];

        }

        //---------------------------------------------------------------------
        // V vseh testnih primerih velja a >= 0, a < stIgralcev,
        // b >= 0, b < stIgralcev in a != b.
        //---------------------------------------------------------------------
        public int[] medsebojneTocke(int a, int b) {
            return null;
        }

        //---------------------------------------------------------------------
        public int pariZRemijem() {
            // popravite / dopolnite ...
            return -1;
        }
    }
}
