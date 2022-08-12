
// 
// (v prej"snji vrstici dopi"site va"so vpisno "stevilko)

public class Druga {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    //=========================================================================
    public static class TrgovskiCenter {
        private Trgovina[][] trgovine;   // pravokotna tabela

        public TrgovskiCenter(Trgovina[][] trgovine) {
            this.trgovine = trgovine;
        }

        public Trgovina[][] vrniTrgovine() {
            return this.trgovine;
        }

        // po potrebi dodajte pomo"zne metode ...

        //---------------------------------------------------------------------
        // V vseh testnih primerih velja 
        //
        // vr >= 1, st >= 1, vr < st_vrstic - 1, st < st_stolpcev - 1,
        //
        // pri "cemer st_vrstic in st_stolpcev ozna"cujeta "stevilo vrstic in
        // stolpcev tabele this.trgovine.
        //---------------------------------------------------------------------
        public boolean vSosescini(int vr, int st, String naziv) {
            for (int i = 0; i < this.trgovine.length; i++) {
                for (int j = 0; j < this.trgovine[i].length; j++) { 
                    for (int k = 0; k < this.trgovine[i][j].vrniIzdelke().length; k++) {
                        if (this.trgovine[vr][st].vrniIzdelke()[k].vrniNaziv().equals(naziv))
                            return true;
                    }
                }
            }
            return false;
        }

        //---------------------------------------------------------------------
        // V vseh testnih primerih so vsi premiki v tabeli legalni 
        // (ne more se zgoditi, da bi nas premik usmeril izven meja tabele
        // trgovin).  Velja premiki.length >= 0 in premiki.length < 200.
        //---------------------------------------------------------------------
        public int pohod(int[][] premiki, String naziv) {
            // popravite / dopolnite ...
            return 99999;
        }
    }

    //=========================================================================
    public static class Trgovina {
        private Izdelek[] izdelki;
        private int[] zaloga;       // enako dolga kot tabela this.izdelki
        private int saldo;

        public Trgovina(Izdelek[] izdelki, int[] zaloga) {
            this.izdelki = izdelki;
            this.zaloga = zaloga;
            this.saldo = 0;
        }

        public Izdelek[] vrniIzdelke() {
            return this.izdelki;
        }

        public int[] vrniZalogo() {
            return this.zaloga;
        }

        public int vrniSaldo() {
            return this.saldo;
        }

        // po potrebi dodajte pomo"zne metode ...

        //---------------------------------------------------------------------
        public int poisciIzdelek(String naziv) {
            int index = -1;
            for (int i = 0; i < this.izdelki.length; i++) {
                if (this.izdelki[i].vrniNaziv().equals(naziv))
                    index = i;
            }
            return index;
        }

        //---------------------------------------------------------------------
        // V vseh testnih primerih velja
        // indeks >= 0 in indeks < this.izdelki.length.
        //---------------------------------------------------------------------
        public int prodaj(int indeks, int n) {
            int zaloga1 = 0;
            int prihodek = 0;
            if (this.zaloga[indeks] >= n) {
                prihodek += n * this.izdelki[indeks].vrniCeno();
                this.zaloga[indeks] -= n;
                this.saldo += prihodek;
            }
            else {
                zaloga1 = this.zaloga[indeks];
                prihodek += zaloga1 * this.izdelki[indeks].vrniCeno();
                this.zaloga[indeks] -= zaloga1;
                this.saldo += prihodek;              
            }
            return prihodek;
        }
    }
    
    
    //=========================================================================
    public static class Izdelek {
        private String naziv;
        private int cena;

        public Izdelek(String naziv, int cena) {
            this.naziv = naziv;
            this.cena = cena;
        }

        public String vrniNaziv() {
            return this.naziv;
        }

        public int vrniCeno() {
            return this.cena;
        }

        // po potrebi dodajte pomo"zne metode ...
    }
}
