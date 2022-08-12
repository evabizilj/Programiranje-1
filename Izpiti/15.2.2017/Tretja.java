
import java.awt.*;

/*
 * TESTNI PRIMERI:
 *
 * J1, S1--S5: klici metode premerOrbite
 *
 * J2--J3, S6--S15: klici metode polozajNaOrbiti
 *
 * J4--J5, S16--S25: samo orbite, brez planetov
 *
 * J6, S26--S30: orbite + krogoni
 *
 * J7, S31--S35: orbite + kvadratoni
 *
 * J2, J4, J6, J8, S1--S2, S6--S10, S16--S20, S26--S27, S31--S32, S36--S40: wp == hp
 */

public class Tretja extends Platno {

    public static void main(String[] args) {
        Planet[] planeti = {
            new Krogon(    Color.GREEN,   3,  1.0 * Math.PI / 3.0),
            new Kvadraton( Color.RED,     5,  2.0 * Math.PI / 3.0),
            new Krogon(    Color.CYAN,    2,  3.0 * Math.PI / 3.0),
            new Kvadraton( Color.MAGENTA, 1,  4.0 * Math.PI / 3.0),
        };

        Tretja tretja = new Tretja(5, planeti);
        tretja.sproziRisanje(args, "Planeti");
    }

    //=========================================================================

    public static abstract class Planet {

        private Color barva;
        private int orbita;
        private double kot;

        protected Planet(Color barva, int orbita, double kot) {
            this.barva = barva;
            this.orbita = orbita;
            this.kot = kot;
        }

        public Color vrniBarvo() {
            return this.barva;
        }

        public int vrniOrbito() {
            return this.orbita;
        }

        public double vrniKot() {
            return this.kot;
        }

        // po potrebi dopolnite ...
        public void narisiPlanet(Graphics2D g, double x, double y, double a) {
          g.setColor(barva);
        }
    }

    //=========================================================================

    public static class Krogon extends Planet {

        public Krogon(Color barva, int orbita, double kot) {
            super(barva, orbita, kot);
        }

        // po potrebi dopolnite ...
        @Override
        public void narisiPlanet(Graphics2D g, double x, double y, double a) {
          super.narisiPlanet(g,x,y,a);
          g.fillOval(ri(x-a/2),ri(y-a/2),ri(a),ri(a));
        }
    }

    //=========================================================================

    public static class Kvadraton extends Planet {

        public Kvadraton(Color barva, int orbita, double kot) {
            super(barva, orbita, kot);
        }

        // po potrebi dopolnite ...
        @Override
        public void narisiPlanet(Graphics2D g, double x, double y, double a) {
          super.narisiPlanet(g,x,y,a);
          g.fillRect(ri(x-a/2),ri(y-a/2),ri(a),ri(a));
        }
    }

    //=========================================================================

    private int stOrbit;
    private Planet[] planeti;

    public Tretja(int stOrbit, Planet[] planeti) {
        this.stOrbit = stOrbit;
        this.planeti = planeti;
    }

    //=========================================================================

    protected void narisi(Graphics2D g, double wp, double hp) {
        // dopolnite ...
        g.setColor(Color.black);
        for(int i=1; i<=stOrbit; i++) {
          double premer=premerOrbite(i,wp,hp);
          g.drawOval(ri(wp/2-premer/2),ri(hp/2-premer/2),ri(premer),ri(premer));
        }
        
        double a=premerOrbite(1,wp,hp)/4;
        for(int i=0; i<planeti.length; i++) {
          double[] xy=polozajNaOrbiti(planeti[i].vrniOrbito(),planeti[i].vrniKot(),wp,hp);
          planeti[i].narisiPlanet(g,xy[0],xy[1],a);
        }
    }

    public double premerOrbite(int orbita, double wp, double hp) {
        // popravite / dopolnite ...
        return Math.min(wp,hp)/stOrbit*orbita;
    }

    public double[] polozajNaOrbiti(int orbita, double kot, double wp, double hp) {
        // popravite / dopolnite ...
        double[] xy=new double[2];
        double r=premerOrbite(orbita,wp,hp)/2;
        xy[0]=wp/2+r*Math.cos(kot);
        xy[1]=hp/2-r*Math.sin(kot);
        return xy;
    }
}
