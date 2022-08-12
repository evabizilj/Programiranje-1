
public class Druga {

    //=========================================================================

    public static class Razpis {
        private Prosilec[] prosilci;
        private Pogoj[] pogoji;

        public Razpis(Prosilec[] prosilci, Pogoj[] pogoji) {
            this.prosilci = prosilci;
            this.pogoji = pogoji;
        }

        //---------------------------------------------------------------------

        public int najboljsi() {
          int najboljsi = -2;
          int index = -1;
          for (int i = 0; i < prosilci.length; i++) {
            if (prosilci[i].izpolnjuje(pogoji) && prosilci[i].presezek(pogoji) > najboljsi) {
              najboljsi = prosilci[i].presezek(pogoji);
              index = i;
            }
          }
          return index;
        }
      }

    //=========================================================================

    public static class Prosilec {

      private int jeziki[];
      private int nivo;
        // po potrebi dodajte atribute ...

        public Prosilec() {
          this.jeziki = new int[10];
          for (int i = 0; i < jeziki.length; i++) {
            jeziki[i] = 0;
          }
        }

        //---------------------------------------------------------------------
        // V vseh testnih primerih velja 0 <= jezik <= 9.
        //---------------------------------------------------------------------

        public void seJeNaucil(int jezik, int nivo) {
          this.jeziki[jezik] = nivo;
        }

        //---------------------------------------------------------------------
        // V vseh testnih primerih velja 0 <= jezik <= 9.
        //---------------------------------------------------------------------

        public int nivo(int jezik) {
          return this.jeziki[jezik];
        }

        //---------------------------------------------------------------------
        // V testnih primerih J3 in S11--S15 vsebuje tabela `pogoji' en sam
        // par jezik-nivo.
        //---------------------------------------------------------------------

        public boolean izpolnjuje(Pogoj[] pogoji) {
          for (int i = 0; i < pogoji.length; i++) {
            if (jeziki[pogoji[i].jezik] < pogoji[i].nivo)
              return false;
          }
          return true;
        }

        //---------------------------------------------------------------------

        public int presezek(Pogoj[] pogoji) {
          int razlika = 0;
          for (int i = 0; i < pogoji.length; i++) {
            razlika += jeziki[pogoji[i].jezik] - pogoji[i].nivo;
          }
          return razlika;
        }
      }

    //=========================================================================

    public static class Pogoj {
        private int jezik;
        private int nivo;

        public Pogoj(int jezik, int nivo) {
            this.jezik = jezik;
            this.nivo = nivo;
        }

        public int vrniJezik() {
            return this.jezik;
        }

        public int vrniNivo() {
            return this.nivo;
        }
      }
    }
