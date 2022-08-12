
/*
 * Testni primeri:
 * -- J1, S1--S5: brez risanja; kli"ce se metoda stranicaObmocja
 * -- J2, S6--S10: brez risanja; kli"ceta se metodi xObmocja in yObmocja
 * -- J3--J10, S11--S50: risanje
 * -- J3--J6, S11--S30: platno je kvadrat
 *
 * Realno"stevilske argumente metod g.draw* in g.fill* pretvorite v
 * celo"stevilske s pomo"cjo metode ri.
 */

import java.awt.*;

public class Tretja extends Platno {

    // Po potrebi lahko dopolnjujete tudi razrede Element, Stavba, Drevo in
    // CestniOdsek.

    public static abstract class Element {
        private Color barva;     // barva elementa

        protected Element(Color barva) {
            this.barva = barva;
        }

        protected void narisiPosamezne(Graphics2D g, double stranicaObmocja, double xSredisce, double ySredisce, double dEnota) {
            g.setColor(this.barva);
        }
    }

    public static class Stavba extends Element {    // stavba v obliki pravokotnika
        private double x, y;   // koordinati zgornjega levega ogli"s"ca stavbe
        private double w, h;   // "sirina (w) in vi"sina (h) stavbe

        public Stavba(Color barva, double x, double y, double w, double h) {
            super(barva);
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        public void narisiPosamezne(Graphics2D g, double stranicaObmocja, double xSredisce, double ySredisce, double dEnota) {
            super.narisiPosamezne(g, stranicaObmocja, xSredisce, ySredisce, dEnota);
            g.fillRect(ri(xSredisce + this.x * dEnota), ri(ySredisce - this.y * dEnota), ri (this.w * dEnota), ri(this.h * dEnota));
        }
    }

    public static class Drevo extends Element {    // drevo v obliki kroga
        private double x, y;  // koordinati sredi"s"ca drevesa
        private double r;     // polmer drevesa

        public Drevo(Color barva, double x, double y, double r) {
            super(barva);
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public void narisiPosamezne(Graphics2D g, double stranicaObmocja, double xSredisce, double ySredisce, double dEnota) {
            super.narisiPosamezne(g, stranicaObmocja, xSredisce, ySredisce, dEnota);
            g.fillOval(ri(xSredisce + (this.x - this.r) * dEnota), ri(ySredisce - (this.y + this.r) * dEnota), ri(2.0 * dEnota * this.r), ri(2.0 * dEnota * this.r));
        }
    }

    public static class CestniOdsek extends Element {    // cestni odsek v obliki daljice
        private double x1, y1;   // koordinati prvega kraji"s"ca cestnega odseka
        private double x2, y2;   // koordinati drugega kraji"s"ca cestnega odseka

        public CestniOdsek(Color barva, double x1, double y1, double x2, double y2) {
            super(barva);
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        public void narisiPosamezne(Graphics2D g, double stranicaObmocja, double xSredisce, double ySredisce, double dEnota) {
            super.narisiPosamezne(g, stranicaObmocja, xSredisce, ySredisce, dEnota);
            g.drawLine(ri(xSredisce + dEnota * this.x1), ri(ySredisce - dEnota * this.y1), ri(xSredisce + dEnota * this.x2), ri(ySredisce - dEnota * this.y2));
        }
    }

    //-------------------------------------------------------------------------
    public static void main(String[] args) {
        Element[] elementi = {
            new Stavba(Color.RED, -0.7, 0.7, 0.5, 0.3),
            new Drevo(Color.GREEN, 0.6, 0.0, 0.2),
            new CestniOdsek(Color.MAGENTA, -0.8, -0.4, 0.0, 0.5),
            new CestniOdsek(Color.BLUE, 0.0, 0.5, 0.3, -0.1),
            new CestniOdsek(Color.ORANGE, 0.8, -0.4, -0.1, -0.9),
            new Drevo(Color.CYAN, -0.3, -0.6, 0.1)
        };

        Tretja tretja = new Tretja(elementi);
        tretja.sproziRisanje(args, "Tloris");
    }

    //-------------------------------------------------------------------------

    // elementi obmo"cja
    private Element[] elementi;

    //-------------------------------------------------------------------------
    public Tretja(Element[] elementi) {
        this.elementi = elementi;
    }

    //-------------------------------------------------------------------------
    // Na platno nari"se tloris obmo"cja.
    // wp: "sirina platna
    // hp: vi"sina platna
    //-------------------------------------------------------------------------
    protected void narisi(Graphics2D g, double wp, double hp) {
        double stranicaObmocja = stranicaObmocja(wp, hp);
        double x = xObmocja(wp, hp);
        double y = yObmocja(wp, hp);
        double dEnota = stranicaObmocja / 2; // razdalja v koordinatnem sistemu platna, ki ustreza razdalji 1 v matematicnem koordinatnem sistemu
        double xSredisce = x + dEnota;
        double ySredisce = y + dEnota;


        // okvir
        g.setColor(Color.BLACK);
        g.drawRect(ri(x), ri(y), ri(stranicaObmocja), ri(stranicaObmocja));

        // elementi
        for (int i = 0; i < this.elementi.length; i++) {
            if (this.elementi[i] instanceof Stavba) {
                this.elementi[i].narisiPosamezne(g, stranicaObmocja, xSredisce, ySredisce, dEnota);

            }
            if (this.elementi[i] instanceof Drevo) {
                this.elementi[i].narisiPosamezne(g, stranicaObmocja, xSredisce, ySredisce, dEnota);
            }
            if (this.elementi[i] instanceof CestniOdsek) {
                this.elementi[i].narisiPosamezne(g, stranicaObmocja, xSredisce, ySredisce, dEnota);
            }
        }
    }

    //-------------------------------------------------------------------------
    // Vrne dol"zino stranice obmo"cja (v pikslih).
    // wp: "sirina platna
    // hp: vi"sina platna
    //-------------------------------------------------------------------------
    public double stranicaObmocja(double wp, double hp) {
        return Math.min(wp, hp);
    }

    //-------------------------------------------------------------------------
    // Vrne koordinato x zgornjega levega ogli"s"ca obmo"cja (v pikslih).
    // wp: "sirina platna
    // hp: vi"sina platna
    //-------------------------------------------------------------------------
    public double xObmocja(double wp, double hp) {
      return (wp - stranicaObmocja(wp, hp))/2;
      // 2x = wp - stranicaObmocja
      // x = 
    }

    //-------------------------------------------------------------------------
    // Vrne koordinato y zgornjega levega ogli"s"ca obmo"cja (v pikslih).
    // wp: "sirina platna
    // hp: vi"sina platna
    //-------------------------------------------------------------------------
    public double yObmocja(double wp, double hp) {
        return (hp - stranicaObmocja(wp, hp))/2;
    }
}
