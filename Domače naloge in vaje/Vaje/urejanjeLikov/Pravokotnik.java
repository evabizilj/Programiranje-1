
/** Objekt tega razreda predstavlja pravokotnik. */
public class Pravokotnik extends Lik {

    // dol"zini stranic pravokotnika;
    // `protected' zato, da bosta dostopni tudi v podrazredih
    protected int a, b;

    public Pravokotnik(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int obseg() {
        return 2 * (this.a + this.b);
    }

    public int ploscina() {
        return this.a * this.b;
    }

    public String vrsta() {
        return "pravokotnik";
    }

    public String podatki() {
        return String.format("a = %d, b = %d", this.a, this.b);
    }

    public int tip() {
        return 1;
    }
}
