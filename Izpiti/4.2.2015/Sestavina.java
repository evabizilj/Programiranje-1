
public class Sestavina {

    private String naziv;     // naziv sestavine, npr. "moka"
    private double kalorije;  // "stevilo kcal na 100 gramov sestavine
    private int oh;           // dele"z ogljikovih hidratov (v odstotkih)
    private int beljakovine;  // dele"z beljakovin (v odstotkih)
    private int mascobe;      // dele"z ma"s"cob (v odstotkih)

    public Sestavina(String naziv, double kalorije, int oh, int beljakovine, int mascobe) {
        this.naziv = naziv;
        this.kalorije = kalorije;
        this.oh = oh;
        this.beljakovine = beljakovine;
        this.mascobe = mascobe;
    }

    public String vrniNaziv() {
        return this.naziv;
    }

    public double vrniKalorije() {
        return this.kalorije;
    }

    public int vrniOH() {
        return this.oh;
    }

    public int vrniBeljakovine() {
        return this.beljakovine;
    }

    public int vrniMascobe() {
        return this.mascobe;
    }
}
