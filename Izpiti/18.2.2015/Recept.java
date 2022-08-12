
/**
 * NALOGA 2
 */

public class Recept {    // kuharski recept

    private Korak[] koraki;    // koraki recepta

    public Recept(Korak[] koraki) {
        this.koraki = koraki;
    }

    public Korak[] vrniKorake() {
        return this.koraki;
    }

    /**
     * Naloga (a) -- vrne trajanje recepta v minutah.
     */

    public int trajanje() {
      int trajanje = 0;
      for (int i = 0; i < this.koraki.length; i++) {
        trajanje += this.koraki[i].vrniTrajanje();
      }
      return trajanje;
    }
    /**
     * Naloga (b) -- vrne indeks prvega koraka s podano akcijo (-1, "ce te
     * akcije ni).
     */
    public int prviKorakZAkcijo(String akcija) {
      int index = -1;
      for (int i = 0; i < this.koraki.length; i++) {
        if (this.koraki[i].vrniAkcijo().equals(akcija))
          return i;
      }
      return index;
    }

    /**
     * Naloga (d) -- vrne "stevilo snovi, ki se pojavljajo SAMO na vhodih v
     * korake recepta.
     */

    // vstopna snov ni na izhodu
     
    public int steviloVstopnihSnovi() {
      int stevilo = 0;
      // snovi v vseh vhodih na vseh korakih
      for (int i = 0; i < this.koraki.length; i++) {
        for (int j = 0; j < this.koraki[i].vrniVhode().length; j++) {
          if (this.koraki[i].vrniVhode()[j].naIzhodu(this) == false)
            stevilo++;
        }
      }
      return stevilo;
    }
  }

 