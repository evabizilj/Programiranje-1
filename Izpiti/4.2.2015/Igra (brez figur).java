
// Dopolnite samo metode narisi, stranicaCelice in zgorajLevo.

import java.awt.*;

public class Igra extends Platno {

    //=========================================================================
    // Pomo"zne definicije
    //=========================================================================

    /**
     * Objekt tega razreda predstavlja celico labirinta.
     */
    public static class Celica {
        // vrednost true pove, da se na levi/zgornji/desni/spodnji stranici
        // nahaja stena
        private boolean levo, zgoraj, desno, spodaj;

        public Celica(boolean levo, boolean zgoraj, boolean desno, boolean spodaj) {
            this.levo = levo;
            this.zgoraj = zgoraj;
            this.desno = desno;
            this.spodaj = spodaj;
        }

        public boolean vrniLevo() { return this.levo; }
        public boolean vrniZgoraj() { return this.zgoraj; }
        public boolean vrniDesno() { return this.desno; }
        public boolean vrniSpodaj() { return this.spodaj; }
    }

    /**
     * Objekt tega razreda predstavlja figuro.
     */
    public static abstract class Figura {
        private int vrstica;  // indeks vrstice celice, kjer se nahaja figura `this'
        private int stolpec;  // indeks stolpca celice, kjer se nahaja figura `this'
        private Color barva;  // barva figure `this'

        public Figura(int vrstica, int stolpec, Color barva) {
            this.vrstica = vrstica;
            this.stolpec = stolpec;
            this.barva = barva;
        }

        public int vrniVrstico() { return this.vrstica; }
        public int vrniStolpec() { return this.stolpec; }
        public Color vrniBarvo() { return this.barva; }
    }

    public static class Pacman extends Figura {
        public Pacman(int vrstica, int stolpec, Color barva) {
            super(vrstica, stolpec, barva);
        }
    }

    public static class Duh extends Figura {
        public Duh(int vrstica, int stolpec, Color barva) {
            super(vrstica, stolpec, barva);
        }
    }

    private static final boolean T = true;
    private static final boolean F = false;

    // delajte s tabelo `celice', ne `CELICE' (to je samo primer!)
    private static final Celica[][] CELICE = {
        { new Celica(T, T, T, F), new Celica(T, T, F, T), new Celica(F, T, F, F), new Celica(F, T, T, F) },
        { new Celica(T, F, F, F), new Celica(F, T, F, T), new Celica(F, F, T, T), new Celica(T, F, T, F) },
        { new Celica(T, F, T, T), new Celica(T, T, T, T), new Celica(T, T, F, F), new Celica(F, F, T, T) },
        { new Celica(T, T, F, T), new Celica(F, T, T, T), new Celica(T, F, F, T), new Celica(F, T, T, T) },
    };

    // delajte s tabelo `figure', ne `FIGURE' (to je samo primer!)
    private static final Figura[] FIGURE = {
        new Pacman(1, 1, Color.RED), new Duh(3, 1, Color.BLUE),
        new Pacman(0, 3, Color.GREEN), new Duh(2, 2, Color.ORANGE)
    };

    //=========================================================================
    // Metoda main
    //=========================================================================

    public static void main(String[] args) {
        Igra igra = new Igra(CELICE, FIGURE);
        igra.sproziRisanje(args);
    }

    // celice labirinta
    private Celica[][] celice;

    // figure
    private Figura[] figure;

    // "stevilo celic v obeh smereh (tabela `celice' je kvadratna)
    private int stCelic;

    public Igra(Celica[][] celice, Figura[] figure) {
        this.celice = celice;
        this.figure = figure;
        this.stCelic = this.celice.length;
    }

    protected void narisi(Graphics2D g, double wp, double hp) {
        double[] xyLabirint = zgorajLevo(wp, hp);
        double stranica = stranicaCelice(wp, hp);

      // risanje labirinta
        for (int i = 0; i < stCelic; i++) {
            for (int j = 0; j < stCelic; j++) {
                // izracun zgornjega levega oglisca
                double x = ri (xyLabirint[0] + j * stranica);
                double y = ri (xyLabirint[1] + i * stranica);
                g.setColor(Color.BLACK);
                if (celice[i][j].vrniLevo())
                    g.drawLine(ri(x), ri(y), ri(x), ri(y + stranica));
                if (celice[i][j].vrniZgoraj())
                    g.drawLine(ri(x), ri(y), ri(x + stranica), ri(y));
                if (celice[i][j].vrniDesno())
                    g.drawLine(ri(x + stranica), ri(y), ri(x + stranica), ri(y + stranica));
                if (celice[i][j].vrniSpodaj())
                    g.drawLine(ri(x), ri(y + stranica), ri(x + stranica), ri(y + stranica));
            }
        }

        // risanje figur 
        for (int i = 0; i < this.figure.length; i++) {
            double x = xyLabirint[0] + figure[i].vrniStolpec() * stranica;
            double y = xyLabirint[1] + figure[i].vrniVrstico() * stranica;
            if (figure[i] instanceof Pacman) {
                g.setColor(figure[i].vrniBarvo());
                g.fillArc(ri((x + stranica) / 4.0), ri((y + stranica) / 4.0), ri(stranica / 2.0), ri(stranica / 2.0), 45, 270);
            }
            else {
                g.fillArc(ri(x + stranica / 4.0), ri(y + stranica / 4.0), ri(stranica / 2.0), ri(stranica / 2.0), 0, 180);
                g.fillRect(ri(x + stranica / 4.0), ri(y + stranica / 2.0), ri(stranica / 2.0), ri(stranica / 4.0));
            }
        }
    }




    public double stranicaCelice(double wp, double hp) {
      return Math.min(wp, hp) / this.celice.length;
    }

    public double[] zgorajLevo(double wp, double hp) {
      double stranica = Math.min(wp, hp);
      double x = (wp - stranica) / 2.0;
      double y = (hp - stranica) / 2.0;
      return new double[] {x, y};
    }
}