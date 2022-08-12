
/**
 * NALOGA 2
 */

public class Korak {   // korak kuharskega recepta

    private Snov[] vhodi;   // jedilne snovi, ki vstopajo v korak
    private Snov[] izhodi;  // jedilne snovi, ki so rezultat koraka
    private String akcija;  // akcija, npr. "zmesaj"
    private int trajanje;   // trajanje koraka v minutah

    public Korak(Snov[] vhodi, Snov[] izhodi, String akcija, int trajanje) {
        this.vhodi = vhodi;
        this.izhodi = izhodi;
        this.akcija = akcija;
        this.trajanje = trajanje;
    }

    public Snov[] vrniVhode() {
        return this.vhodi;
    }

    public Snov[] vrniIzhode() {
        return this.izhodi;
    }

    public String vrniAkcijo() {
        return this.akcija;
    }

    public int vrniTrajanje() {
        return this.trajanje;
    }

}
