
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
    public static class Figura {
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
        
        public void narisiFiguro(Graphics2D g, double x, double y, double aCelice) {
          g.setColor(barva);
        }
    }

    public static class Pacman extends Figura {
        public Pacman(int vrstica, int stolpec, Color barva) {
            super(vrstica, stolpec, barva);
        }
        
        @Override
        public void narisiFiguro(Graphics2D g, double x, double y, double aCelice) {
          super.narisiFiguro(g,x,y,aCelice);
          g.fillArc(ri(x+aCelice/4),ri(y+aCelice/4),ri(aCelice/2),ri(aCelice/2),45,270);
        }
    }

    public static class Duh extends Figura {
        public Duh(int vrstica, int stolpec, Color barva) {
            super(vrstica, stolpec, barva);
        }
        
        @Override
        public void narisiFiguro(Graphics2D g, double x, double y, double aCelice) {
          super.narisiFiguro(g,x,y,aCelice);
          g.fillArc(ri(x+aCelice/4),ri(y+aCelice/4),ri(aCelice/2),ri(aCelice/2),0,180);
          g.fillRect(ri(x+aCelice/4),ri(y+aCelice/2),ri(aCelice/2),ri(aCelice/4));
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
        // Dopolnite!
        double[] xyLabirinta=zgorajLevo(wp,hp);
        double aCelice=stranicaCelice(wp,hp);
        
        // risanje labirinta
        g.setColor(Color.BLACK);
        for(int i=0; i<stCelic; i++) {
          for (int j=0; j<stCelic; j++) {
            // izracun levega gornjega oglisca celica
            int x=ri(xyLabirinta[0]+j*aCelice);
            int y=ri(xyLabirinta[1]+i*aCelice);
          
            if(celice[i][j].vrniLevo()) {
              g.drawLine(x,y,x,ri(y+aCelice));
            }
            if(celice[i][j].vrniZgoraj()) {
              g.drawLine(x,y,ri(x+aCelice),y);
            }
            if(celice[i][j].vrniDesno()) {
              g.drawLine(ri(x+aCelice),y,ri(x+aCelice),ri(y+aCelice));
            }
            if(celice[i][j].vrniSpodaj()) {
              g.drawLine(x,ri(y+aCelice),ri(x+aCelice),ri(y+aCelice));
            }            
          }
        }
        
        // risanje figur
        for(int i=0; i<figure.length; i++) {
          // koordinati levega gornjega oglisca celice, kjer se nahaja figura
          double x = xyLabirinta[0]+figure[i].vrniStolpec()*aCelice;
          double y = xyLabirinta[1]+figure[i].vrniVrstico()*aCelice;
          // risanje figure
          figure[i].narisiFiguro(g,x,y,aCelice);
        }
    }

    public double stranicaCelice(double wp, double hp) {
        // Dopolnite!
        double stranicaLabirinta=Math.min(wp,hp);
        return stranicaLabirinta/celice.length;   // Spremenite!
    }

    public double[] zgorajLevo(double wp, double hp) {
        // Dopolnite!
        double stranicaLabirinta=Math.min(wp,hp);
        double[] koordinati=new double[2];
        koordinati[0]=(wp-stranicaLabirinta)/2;
        koordinati[1]=(hp-stranicaLabirinta)/2;
        return koordinati;   // Spremenite!
    }
}
