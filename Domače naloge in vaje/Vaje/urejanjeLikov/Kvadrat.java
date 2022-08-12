
/** Objekt tega razreda predstavlja kvadrat. */
public class Kvadrat extends Pravokotnik {

    // atributa a in b se dedujeta

    public Kvadrat(int a) {
        super(a, a);
    }

    // Plo"s"cina in obseg se izra"cunata na enak na"cin kot pri pravokotniku,
    // zato nam metod `ploscina' in `obseg' ni treba redefinirati.

    public String vrsta() {
        return "kvadrat";
    }

    public String podatki() {
        return String.format("a = %d", this.a);
    }

    public int tip() {
        return 2;
    }
}
