
/** Objekt tega razreda predstavlja nek geometrijski lik. */
public abstract class Lik {

    /** Vrne obseg lika this. */
    public abstract int obseg();

    /** Vrne plo"s"cino lika this. */
    public abstract int ploscina();

    /** Vrne predstavitev lika this v obliki niza. */
    public String toString() {
        // Poklicale se bodo konkretne implementacije metod v podrazredih.
        // Izbira metode je odvisna od dinami"cnega tipa objekta, na katerega
        // ka"ze referenca this.
        return String.format("%s [%s] | p = %d, o = %d",
                this.vrsta(), this.podatki(), this.ploscina(), this.obseg());
    }

    /** Vrne niz, ki predstavlja vrsto lika this. */
    public abstract String vrsta();

    /** Vrne niz, ki vsebuje podatke o liku this. */
    public abstract String podatki();

    /** Vrne zaporedno "stevilko tipa lika this. */
    public abstract int tip();
}
