
/**
 * NALOGA 2
 */

public class Snov {    // jedilna snov

    private String naziv;   // unikaten naziv, npr. "moka" ali "palacinke"

    public Snov(String naziv) {
        this.naziv = naziv;
    }

    public String vrniNaziv() {
        return this.naziv;
    }

    /**
     * Naloga (c) -- preveri, ali snov this nastopa na izhodu vsaj enega
     * koraka podanega recepta.
     */

    public boolean naIzhodu(Recept recept) {
        for (int i = 0; i < recept.vrniKorake().length; i++) {
            for (int j = 0; j < recept.vrniKorake()[i].vrniIzhode().length; j++) {
                if (recept.vrniKorake()[i].vrniIzhode()[j].vrniNaziv().equals(this.vrniNaziv()))
                    return true;
            }
        }
        return false;
    }
  }
