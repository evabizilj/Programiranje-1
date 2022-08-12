
/**
 * NALOGA 3
 *
 * Dopolnite/spremenite SAMO ozna"ceni del razreda!
 */

import java.awt.*;

public class Diagram extends Platno {

    //=========================================================================
    // Notranji razredi
    //=========================================================================

    public static class Skatla {
        private int stRazdelkov;
        private double x, y;

        public Skatla(int stRazdelkov, double x, double y) {
            this.stRazdelkov = stRazdelkov;
            this.x = x;
            this.y = y;
        }

        public int vrniStRazdelkov() {
            return this.stRazdelkov;
        }

        public double vrniX() {
            return this.x;
        }

        public double vrniY() {
            return this.y;
        }

        public String toString() {
            return String.format("[stRazdelkov = %d, x = %.1f, y = %.1f]", this.stRazdelkov, this.x, this.y);
        }
    }

    public static class Povezava {
        private Skatla prva, druga;

        public Povezava(Skatla prva, Skatla druga) {
            this.prva = prva;
            this.druga = druga;
        }

        public Skatla vrniPrvo() {
            return this.prva;
        }

        public Skatla vrniDrugo() {
            return this.druga;
        }
    }

    //=========================================================================
    // Primer
    //=========================================================================

    // POZOR!
    //
    // Uporabljajte atribute, ne konstante (torej this.skatle, ne SKATLE)!

    private static final Skatla[] SKATLE = {
        new Skatla(3, 2.0, 1.0),
        new Skatla(1, 0.0, 7.0),
        new Skatla(2, 7.0, 1.0),
        new Skatla(4, 6.0, 5.0),
    };

    private static final Povezava[] POVEZAVE = {
        new Povezava(SKATLE[0], SKATLE[1]),
        new Povezava(SKATLE[0], SKATLE[2]),
        new Povezava(SKATLE[0], SKATLE[3]),
        new Povezava(SKATLE[2], SKATLE[3]),
    };

    private static final double D_PAPIR = 10.0;
    private static final double W_SKATLA = 2.0;

    //=========================================================================
    // Metoda main
    //=========================================================================

    public static void main(String[] args) {
        Diagram diagram = new Diagram(SKATLE, POVEZAVE, D_PAPIR, W_SKATLA);
        diagram.sproziRisanje(args);
    }

    //=========================================================================
    // Atributi, konstruktor in nestati"cne metode
    //=========================================================================

    private Skatla[] skatle;      // "skatle
    private Povezava[] povezave;  // povezave med "skatlami
    private double dPapir;        // dol"zina stranice lista papirja (v cm)
    private double wSkatla;       // "sirina "skatle (v cm)

    public Diagram(Skatla[] skatle, Povezava[] povezave, double dPapir, double wSkatla) {
        this.skatle = skatle;
        this.povezave = povezave;
        this.dPapir = dPapir;
        this.wSkatla = wSkatla;
    }

    //=========================================================================
    // DOPOLNITE / SPREMENITE!
    //=========================================================================

    // wp: "sirina platna
    // hp: vi"sina platna

    protected void narisi(Graphics2D g, double wp, double hp) {
        // Dopolnite ...

        // povezave
        for (int i = 0; i < this.povezave.length; i++) {
            Povezava povezava = this.povezave[i];

            Skatla skatla1 = povezava.vrniPrvo();
            Skatla skatla2 = povezava.vrniDrugo();

            double[] sredisce1 = sredisceSkatle(skatla1, wp, hp);
            double[] sredisce2 = sredisceSkatle(skatla2, wp, hp);

            g.setColor(Color.RED);
            g.drawLine(ri(sredisce1[0]), ri(sredisce1[1]), ri(sredisce2[0]), ri(sredisce2[1]));
        }

        // skatle
        for (int i = 0; i < this.skatle.length; i++) {
            double zacetekX = this.skatle[i].vrniX() * pix(wp, hp);
            double konecX = sirinaSkatle(wp, hp);
            double zacetekY = this.skatle[i].vrniY() * pix(wp, hp);
            double konecY = this.skatle[i].vrniStRazdelkov() * visinaRazdelka(wp, hp);

            g.setColor(Color.BLACK);
            g.drawRect(ri(zacetekX), ri(zacetekY), ri(konecX), ri(konecY));
            g.setColor(Color.YELLOW);
            g.fillRect(ri(zacetekX), ri(zacetekY), ri(konecX), ri(konecY));     
            
            // razdelki
            for (int j = 0; j < this.skatle[i].vrniStRazdelkov(); j++) {
                g.setColor(Color.BLACK);
                g.drawRect(ri(zacetekX), ri(zacetekY), ri(konecX), ri(visinaRazdelka(wp, hp)));
                zacetekY = zacetekY + visinaRazdelka(wp, hp);
            }
        }
    }

    /**
     * Vrne "sirino "skatle v pikslih.
     */
    public double sirinaSkatle(double wp, double hp) {
        return wSkatla * pix(wp, hp);
    }

    public double visinaRazdelka(double wp, double hp) {
        return 1 * pix(wp, hp);
    }

    public double pix(double wp, double hp) {
        double sirina = Math.min(wp, hp);
        return sirina / dPapir;
    }

    /**
     * Vrne koordinati sredi"s"ca podane "skatle v pikslih.
     */
    public double[] sredisceSkatle(Skatla sk, double wp, double hp) {
        double x = sk.vrniX() * pix(wp, hp) + sirinaSkatle(wp, hp) / 2.0;
        double y = sk.vrniY() * pix(wp, hp) + sk.vrniStRazdelkov() / 2.0 * pix(wp, hp);
        return new double[] {x, y};

    }
}
