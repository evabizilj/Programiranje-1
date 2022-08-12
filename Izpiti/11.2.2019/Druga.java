
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

import java.util.Arrays;

public class Druga {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    //=========================================================================
    public static class Oseba {
        private String ip;
        private Clanek[] clanki;

        public Oseba(String ip) {
            this.ip = ip;
        }

        public String vrniIP() {
            return this.ip;
        }

        public void nastaviClanke(Clanek[] clanki) {
            this.clanki = clanki;
        }

        public Clanek[] vrniClanke() {
            return this.clanki;
        }

        public Clanek najboljCitiran() {
            int max = 0;
            int index = 0;
           for (int i = 0; i < this.clanki.length; i++) {
               if (this.clanki[i].vrniStCitatov() > max) {
                   max = this.clanki[i].vrniStCitatov();
                   index = i;
               }
           }
            return this.clanki[index];
        }

        public boolean jeSoavtorZ(Oseba oseba) {
            for (int i = 0; i < this.clanki.length; i++) {
                for (int j = 0; j < this.clanki[i].vrniAvtorje().length; j++) {
                    if (this.clanki[i].vrniAvtorje()[j].vrniIP().equals(oseba.vrniIP()))
                        return true;
                }
            }
            return false;
        }

        //
        // V testnih primerih J8 in S38--S41 so "clanki v tabeli this.clanki
        // urejeni po padajo"cem "stevilu citatov.
        //
        public int hIndeks() {
            int h = 0;
            int soAvtor = 0;
            for (int i = 0; i < this.clanki.length; i++) {
                for (int j = 0; j < this.clanki[i].vrniAvtorje().length; j++) {
                    if (this.clanki[i].vrniAvtorje()[j].jeSoavtorZ(this))
                        soAvtor++;
                }
            }
            h = soAvtor;
            return h;
        }

        // po potrebi dodajte svoje metode ...
    }

    //=========================================================================

    public static class Clanek {
        private String naslov;
        private Oseba[] avtorji;
        private int stCitatov;

        public Clanek(String naslov, Oseba[] avtorji, int stCitatov) {
            this.naslov = naslov;
            this.avtorji = avtorji;
            this.stCitatov = stCitatov;
        }

        public String vrniNaslov() {
            return this.naslov;
        }

        public Oseba[] vrniAvtorje() {
            return this.avtorji;
        }

        public int vrniStCitatov() {
            return this.stCitatov;
        }

        public String[] ipjiAvtorjev() {
          int steviloAvtorjev = this.vrniAvtorje().length;
          String[] tabela = new String[steviloAvtorjev];
          for (int i = 0; i < tabela.length; i++) {
              tabela[i] = this.vrniAvtorje()[i].vrniIP();
          }
          return tabela;
        }

        // po potrebi dodajte svoje metode ...
    }
}
