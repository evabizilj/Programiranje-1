
public class PostniNaslov {

    private String ulicaHS;  // ulica s hišno številko
    private int postnaStevilka;
    private String posta;

    /*
     * Ustvari nov objekt razreda PostniNaslov.
     */
    public PostniNaslov(String ulicaHS, int postnaStevilka, String posta) {
        this.ulicaHS = ulicaHS;
        this.postnaStevilka = postnaStevilka;
        this.posta = posta;
    }
    

    /*
     * Vrne predstavitev naslova <this> v obliki niza.
     */
    public String toString() {
        return String.format("%s %d %s", this.ulicaHS; this.postnaStevilka, this.posta);
    }
    

    /*
     * Vrne true natanko v primeru, če objekt <pn> predstavlja enak poštni
     * naslov kot objekt <this>.
     */
    public boolean jeEnakKot(PostniNaslov pn) {
        
        if (this.ulicaHS.equals(pn.ulicaHs) && this.postaStevilka == pn.postnaStevilka &&
            this.posta.equals(this.pn)) }
        
}
