
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

import java.awt.*;
import java.util.Arrays;

/*
 * TESTNI PRIMERI:
 *
 * J1, S1--S5: klici metode stranicaZaslona
 *
 * J2, S6--S10: klici metode zgornjiLeviKot
 *
 * J3--J5, S11--S25: kvadratno platno
 *
 * J3--J7, S11--S35: okna so v tabeli this.okna urejena po padajo"ci globini
 *
 * J3--J4, J6, S11--S20, S26--S30: samo navadna okna, brez statusnih
 */

public class Tretja extends Platno {

    public static void main(String[] args) {
        Okno[] okna = {
            new Okno(0.2, 0.1, 0.5, 0.7, 1, Color.GREEN),
            new OknoStatusna(0.1, 0.2, 0.9, 0.4, 2, Color.RED),
            new OknoStatusna(0.5, 0.4, 0.4, 0.5, 0, Color.BLUE),
        };

        Tretja tretja = new Tretja(okna);
        tretja.sproziRisanje(args, "Okna");
    }

    private Okno[] okna;

    public Tretja(Okno[] okna) {
        this.okna = okna;
    }

    //=========================================================================
    public static class Okno {
        public static final Color BARVA_NASLOV = new Color(240, 240, 200);
        public static final Color BARVA_GUMB = new Color(200, 200, 160);

        private double x;
        private double y;
        private double w;
        private double h;
        private int z;
        private Color barva;

        public Okno(double x, double y, double w, double h, int z, Color barva) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.z = z;
            this.barva = barva;
        }

        public double vrniX() { return this.x; }
        public double vrniY() { return this.y; }
        public double vrniW() { return this.w; }
        public double vrniH() { return this.h; }
        public int vrniZ() { return this.z; }
        public Color vrniBarvo() { return this.barva; }

        // po potrebi dopolnite ...
    }

    //=========================================================================
    public static class OknoStatusna extends Okno {
        public static final Color BARVA_STATUS = new Color(144, 168, 192);

        public OknoStatusna(double x, double y, double w, double h, int z, Color barva) {
            super(x, y, w, h, z, barva);
        }

        // po potrebi dopolnite ...
    }

    //=========================================================================
    protected void narisi(Graphics2D g, double wp, double hp) {
        double stranicaZaslona = stranicaZaslona(wp, hp);
        double zacetekX = (wp - Math.min(wp, hp)) / 2.0;
        double zacetekY = (hp - Math.min(wp, hp)) / 2.0;

        g.setColor(Color.BLACK);
        g.drawRect(ri(zacetekX), ri(zacetekY), ri(stranicaZaslona), ri(stranicaZaslona));
    }

    public double stranicaZaslona(double wp, double hp) {
        // popravite / dopolnite ...
        return Math.min(wp, hp);
    }

    public double[] zgornjiLeviKot(double wp, double hp) {
        double x = (wp - Math.min(wp, hp)) / 2.0;
        double y = (hp - Math.min(wp, hp)) / 2.0;
        return new double[] {x, y};
    }

    // po potrebi dopolnite ...
}
