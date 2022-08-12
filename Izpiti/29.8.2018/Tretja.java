
// 
// (v prej"snji vrstici dopi"site va"so vpisno "stevilko)

import java.awt.*;

/*
 * TESTNI PRIMERI:
 *
 * J1--J2, S1--S10: klici metod stranicaPolja, xLevo in yZgoraj
 *
 * J3--J4, S11--S20: vsa polja so navadna polja
 *
 * J5--J6, S21--S30: vsako polje je bodisi navadno polje bodisi presene"cenje
 *
 * J1, J3, J5, J7, S1--S5, S11--S15, S21--S25, S31--S35: platno je kvadratno
 */

public class Tretja extends Platno {

    public static void main(String[] args) {
        int dolzina = 5;

        Polje[] polja = {
            new Polje(),
            new Posest(Color.RED),
            new Presenecenje(),
            new Posest(Color.RED),

            new Polje(),
            new Presenecenje(),
            new Posest(Color.GREEN),
            new Posest(Color.BLUE),

            new Presenecenje(),
            new Posest(Color.GREEN),
            new Presenecenje(),
            new Polje(),

            new Presenecenje(),
            new Posest(Color.ORANGE),
            new Polje(),
            new Posest(Color.BLUE),
        };

        Tretja tretja = new Tretja(dolzina, polja);
        tretja.sproziRisanje(args);
    }

    //=========================================================================
    public static class Polje {

        public Polje() {
        }

        // po potrebi dopolnite ...
    }

    //=========================================================================
    public static class Presenecenje extends Polje {

        public Presenecenje() {
            super();
        }

        // po potrebi dopolnite ...
    }

    //=========================================================================
    public static class Posest extends Polje {

        private Color barva;

        public Posest(Color barva) {
            super();
            this.barva = barva;
        }

        // po potrebi dopolnite ...
    }

    //=========================================================================

    private int dolzina;
    private Polje[] polja;

    public Tretja(int dolzina, Polje[] polja) {
        this.dolzina = dolzina;
        this.polja = polja;
    }

    protected void narisi(Graphics2D g, double wp, double hp) {
        // dopolnite ...
    }

    public double stranicaPolja(double wp, double hp) {
        // popravite / dopolnite ...
        return (Math.min(wp, hp) / this.dolzina);
    }

    public double xLevo(double wp, double hp) {
        // popravite / dopolnite ...
        return (Math.max(wp, hp) - stranicaPolja(wp, hp)) / 2.0;
    }

    public double yZgoraj(double wp, double hp) {
        // popravite / dopolnite ...
        return Math.max(wp, hp);
    }
}
