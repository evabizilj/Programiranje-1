
public class Obrok {

    private Jed[] jedi;   // jedi, ki sestavljajo obrok

    public Obrok(Jed[] jedi) {
        this.jedi = jedi;
    }

    public Jed[] vrniJedi() {
        return this.jedi;
    }

    /**
     * Vrne indeks najbolj kalori"cne beljakovinske jedi v tabeli jedi obroka
     * this.  "Ce je takih jedi ve"c, vrne indeks prve med njimi, "ce pa obrok
     * this ne vsebuje beljakovinskih jedi, vrne -1.
     */
    public int indeksNajboljKaloricneBeljakovinske() {
        int index = -1;
        double maxKalorije = 0.0;
        for (int i = 0; i < this.jedi.length; i++) {
        	if (this.jedi[i].jeBeljakovinska()) {
        		if (this.jedi[i].kalorije() > maxKalorije) {
    				maxKalorije = this.jedi[i].kalorije();
    				index = i;
    			}
        	}
		}
        return index;
    }
    

    /**
     * Vrne skupno maso sestavine (ne jedi!) s podanim nazivom v obroku this.
     */
    public double masaSestavine(String nazivSestavine) {
        double skupnaMasa = 0.0;
        for (int i = 0; i < this.jedi.length; i++) {
            for (int j = 0; j < this.jedi[i].vrniSestavine().length; j++) {
                if (this.jedi[i].vrniSestavine()[j].vrniNaziv().equals(nazivSestavine)) {
                    skupnaMasa += this.jedi[i].vrniMase()[j];
                }

            }
        }
        return skupnaMasa;
    }

    /**
     * Stabilno uredi tabelo this.jedi glede na podani primerjalnik.
     *
     * Ne spreminjajte!
     */
    public void urediJedi(Primerjalnik primerjalnik) {
        for (int i = 1;  i < this.jedi.length;  i++) {
            Jed trenutni = this.jedi[i];
            int j = i;
            while (j > 0 && primerjalnik.jePred(trenutni, this.jedi[j - 1])) {
                this.jedi[j] = this.jedi[j - 1];
                j--;
            }
            this.jedi[j] = trenutni;
        }
    }

}
