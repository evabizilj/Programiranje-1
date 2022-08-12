
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

import java.awt.*;
import java.util.Arrays;

/*
 * TESTNI PRIMERI:
 *
 * J1, S1--S5: klici metode stranicaPolja
 *
 * J2, S6--S10: klici metode zgornjiLeviKot
 *
 * J3--J5, S11--S25: kvadratna tabela this.polje, kvadratno platno
 *
 * J6--J7, S26--S35: kvadratna tabela this.polje
 *
 * J3, S11--S15: brez zastavic, brez min
 *
 * J4, J6, J8, S16--S20, S26--S30, S36--S40: brez zastavic
 */

public class Tretja extends Platno {

    public static void main(String[] args) {
        Polje[][] polja = {
            { new Polje(false), new Polje(false), new Mina(true), new Polje(true) },
            { new Zastavica(), new Polje(true), new Zastavica(), new Mina(true) },
            { new Mina(false), new Polje(false), new Polje(true), new Polje(false) }
        };

        Tretja tretja = new Tretja(polja);
        tretja.sproziRisanje(args, "Minolovec");
    }

    //=========================================================================
    public static class Polje {   // polje

        public static final Color BARVA_ODPRTO = new Color(194, 205, 227);
        public static final Color BARVA_ZAPRTO = new Color(66, 97, 211);

        private boolean odprto;  // true: polje je odprto;  false: polje je zaprto

        public Polje(boolean odprto) {
            this.odprto = odprto;
        }

        public boolean jeOdprto() {
            return this.odprto;
        }

        // po potrebi dopolnite ...
    }

    //=========================================================================
    public static class Mina extends Polje {   // polje z mino

        private boolean obstaja;   // true: mina obstaja;  false: mina ne obstaja

        public Mina(boolean obstaja) {
            super(true);
            this.obstaja = obstaja;
        }

        public boolean aliObstaja() {
            return this.obstaja;
        }

        // po potrebi dopolnite ...
    }

    //=========================================================================
    public static class Zastavica extends Polje {    // polje z zastavico

        public Zastavica() {
            super(true);
        }

        // po potrebi dopolnite ...
    }

    //=========================================================================

    private Polje[][] polja;

    public Tretja(Polje[][] polja) {
        this.polja = polja;
    }

    protected void narisi(Graphics2D g, double wp, double hp) {
        // dopolnite ...
    }

    public double stranicaPolja(double wp, double hp) {
        // popravite / dopolnite ...
        return 0.0;
    }

    public double[] zgornjiLeviKot(double wp, double hp) {
        // popravite / dopolnite ...
        return null;
    }

    // po potrebi dopolnite ...
}
