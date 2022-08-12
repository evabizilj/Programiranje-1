
import java.awt.*;

/**
 * Stolpci s povezovalno "crto in napisi.
 */
public class Stolpci extends Platno {

    public static void main(String[] args) {
        // V odvisnosti od argumentov ukazne vrstice bodisi ustvari okno in
        // plo"s"co ali pa pripravi sliko v pomnilniku, na katero je mo"zno
        // risati.  S stali"s"ca izdelave na"sega programa je to popolnoma
        // vseeno.

        int[] podatki = {150, 70, 120, 190, 60, 130, 40, 100, 80, 60};
        //int[] podatki = {5};
        //int[] podatki = {1, 1, 1};
        Stolpci stolpci = new Stolpci(podatki);
        stolpci.sproziRisanje(args);
    }

    // podatki, ki dolo"cajo vi"sine stolpcev
    private int[] podatki;

    public Stolpci(int[] podatki) {
        this.podatki = podatki;
    }

    /**
     * Nari"se sliko na platno (zaslon ali slikovno datoteko).  To metodo
     * pokli"ce ogrodje, ko je "cas zanjo.
     * @param g objekt, ki nam omogo"ca risanje
     * @param wp "sirina platna
     * @param hp vi"sina platna
     */
    protected void narisi(Graphics2D g, double wp, double hp) {
        // dopolnite ...
    }

    /**
     * Vrne "sirino (v pikslih) posameznega stolpca.
     */
    public double sirinaStolpca(double wp, double hp) {
        // popravite / dopolnite ...
        return -1.0;
    }

    /**
     * Vrne vi"sino (v pikslih) stolpca s podanim indeksom.
     */
    public double visinaStolpca(int ixStolpec, double wp, double hp) {
        // popravite / dopolnite ...
        return -1.0;
    }

    /**
     * Vrne koordinati (v pikslih) sredine zgornjega roba stolpca s podanim indeksom.
     * @return tabela z dvema elementoma ({x, y}).
     */
    public double[] sredinaVrha(int ixStolpec, double wp, double hp) {
        // popravite / dopolnite ...
        return null;
    }
}
