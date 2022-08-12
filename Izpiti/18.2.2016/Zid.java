
// Testni primeri:
// J6, S26--S30: brez posebnih zidakov
// J7, S31--S35: po en poseben zidak na testni primer
// J8--J10, S36--S50: po ve"c posebnih zidakov na testni primer

import java.awt.*;
import java.util.*;

public class Zid extends Platno {

    //-------------------------------------------------------------------------
    // Vsak objekt tega razreda predstavlja nek poseben zidak.
    //-------------------------------------------------------------------------
    public static class Zidak {
        private int vrstica;   // indeks vrstice
        private int stolpec;   // indeks stolpca
        private Color barva;   // barva polnila

        public Zidak(int vrstica, int stolpec, Color barva) {
            this.vrstica = vrstica;
            this.stolpec = stolpec;
            this.barva = barva;
        }

        public int vrniVrstico() {
            return this.vrstica;
        }

        public int vrniStolpec() {
            return this.stolpec;
        }

        public Color vrniBarvo() {
            return this.barva;
        }
    }

    //-------------------------------------------------------------------------
    public static void main(String[] args) {
        int stVrstic = 5;
        int stStolpcev = 8;
        Zidak[] posebniZidaki = {
            new Zidak(1, 3, Color.YELLOW),
            new Zidak(0, 6, Color.BLUE),
            new Zidak(3, 4, Color.GREEN),
            new Zidak(1, 6, Color.ORANGE),
        };

        Zid zid = new Zid(stVrstic, stStolpcev, posebniZidaki);
        zid.sproziRisanje(args, "Zid");
    }

    //-------------------------------------------------------------------------

    // "stevilo vrstic zidu (med 1 in 30)
    private int stVrstic;

    // "stevilo stolpcev zidu (med 2 in 30)
    private int stStolpcev;

    // tabela podatkov o posebnih zidakih
    private Zidak[] posebniZidaki;

    //-------------------------------------------------------------------------
    public Zid(int stVrstic, int stStolpcev, Zidak[] posebniZidaki) {
        this.stVrstic = stVrstic;
        this.stStolpcev = stStolpcev;
        this.posebniZidaki = posebniZidaki;
    }

    //-------------------------------------------------------------------------
    protected void narisi(Graphics2D g, double wp, double hp) {
        double sirinaZidaka = this.sirinaZidaka(wp, hp);
        double visinaZidaka = this.visinaZidaka(wp, hp);
        double x = 0.0;
        double y = this.yZgornjiRob(wp, hp);

        for (int i = 0; i < this.stVrstic; i++) {
           if (i % 2 == 0)
               x = 0.0;
           else
               x = sirinaZidaka / 2.0;
            for (int j = i % 2; j < this.stStolpcev; j++) {
                
                g.setColor(Color.RED);
                g.fillRect(ri(x), ri(y), ri(sirinaZidaka), ri(visinaZidaka));

                g.setColor(Color.BLACK);
                g.drawRect(ri(x), ri(y), ri(sirinaZidaka), ri(visinaZidaka));
                x += sirinaZidaka;
            }
            y += visinaZidaka;
        }

        for (int i = 0; i < this.posebniZidaki.length; i++) {
            Zidak zidak = this.posebniZidaki[i];
            double[] xy = xyZidaka(zidak.vrniVrstico(), zidak.vrniStolpec(), wp, hp);
            g.setColor(zidak.vrniBarvo());
            g.fillRect(ri(xy[0]), ri(xy[1]), ri(sirinaZidaka), ri(visinaZidaka));
            g.setColor(Color.BLACK);
            g.drawRect(ri(xy[0]), ri(xy[1]), ri(sirinaZidaka), ri(visinaZidaka));
        }
    }


    //-------------------------------------------------------------------------
    public double sirinaZidaka(double wp, double hp) {
        return wp / this.stStolpcev;
    }

    //-------------------------------------------------------------------------
    public double visinaZidaka(double wp, double hp) {
        return (hp / 2.0 / this.stVrstic);
    }

    //-------------------------------------------------------------------------
    public double yZgornjiRob(double wp, double hp) {
        return (hp / 4.0);
    }

    //-------------------------------------------------------------------------
    // vr: med 0 in ("stevilo vrstic - 1)
    //
    // st: med 0 in ("stevilo stolpcev - 1) za sode vrednosti vr;
    //     med 0 in ("stevilo stolpcev - 2) za lihe vrednosti vr
    //-------------------------------------------------------------------------
    public double[] xyZidaka(int vr, int st, double wp, double hp) {
        double x = 0.0;
        double sirinaZidaka = sirinaZidaka(wp, hp);
        double visinaZidaka = visinaZidaka(wp, hp);
        if (vr % 2 == 0)
            x = st * sirinaZidaka;
        else
            x = st * sirinaZidaka + sirinaZidaka / 2.0;
        double y = this.yZgornjiRob(wp, hp) + visinaZidaka * vr;
        return new double[] {x, y};
    }
}
