
public class Krog extends Lik {

    private int r;

    public Krog(int r) {
        this.r = r;
    }

    public int obseg() {
        return (int) Math.round(2 * Math.PI * this.r);
    }

    public int ploscina() {
        return (int) Math.round(Math.PI * this.r * this.r);
    }

    public String vrsta() {
        return "krog";
    }

    public String podatki() {
        return String.format("r = %d", this.r);
    }
}
