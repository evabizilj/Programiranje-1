
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

import java.awt.*;

/*
 * TESTNI PRIMERI:
 *
 * J1--J2, S1--S10: klici metode pikNaCm
 *
 * J3--J4, S11--S20: ena sama vrstica
 *
 * J3--J6, S11--S30: vse objave so enako visoke
 *
 * J3, J5, J7, S11--S15, S21--S25, S31--S35: samo oglasi
 */

public class Tretja extends Platno {

    public static void main(String[] args) {

        int sirinaStolpca = 4;

        Objava[][] objave = {
            { new Clanek(5), new Oglas(2), new Oglas(3), new Clanek(1) },
            { new Oglas(1), new Oglas(4), new Clanek(2), new Clanek(3) },
            { new Oglas(3), new Clanek(4), new Oglas(6), new Oglas(2) },
        };

        Tretja tretja = new Tretja(sirinaStolpca, objave);
        tretja.sproziRisanje(args);
    }

    //=========================================================================
    public static abstract class Objava {

        private int visina;

        protected Objava(int visina) {
            this.visina = visina;
        }

        public int vrniVisino() {
            return this.visina;
        }

        // po potrebi dopolnite ...
    }

    //=========================================================================
    public static class Clanek extends Objava {

        public Clanek(int visina) {
            super(visina);
        }

        // po potrebi dopolnite ...
    }

    //=========================================================================
    public static class Oglas extends Objava {

        public Oglas(int visina) {
            super(visina);
        }

        // po potrebi dopolnite ...
    }

    //=========================================================================

    private int sirinaStolpca;
    private Objava[][] objave;

    public Tretja(int sirinaStolpca, Objava[][] objave) {
        this.sirinaStolpca = sirinaStolpca;
        this.objave = objave;
    }

    protected void narisi(Graphics2D g, double wp, double hp) {
        int steviloStolpcev = 0;
        for (int i = 0; i < this.objave.length; i++) {
            steviloStolpcev = this.objave[i].length;
        }

        double pix = pikNaCm(wp, hp);
        double xZacetek = 0;
        double[] yZacetek = new double[steviloStolpcev];

        for (int i = 0; i < this.objave.length; i++) { // vrstica 
            xZacetek = pix;
            for (int j = 0; j < this.objave[i].length; j++) { // stolpec
                Objava objava = this.objave[i][j];

                if (objava instanceof Clanek) {
                    g.setColor(Color.BLACK);
                    g.drawRect(ri(xZacetek + j * pix), ri(yZacetek[j] + i * pix + pix), ri(this.sirinaStolpca * pix), ri(objava.vrniVisino() * pix));
                    double steviloDaljic = objava.vrniVisino() - 1;
                    double dolzinaDaljice = this.sirinaStolpca / 2.0;
                    double x = xZacetek + j * pix + this.sirinaStolpca / 4.0 + pix;
                    double y = yZacetek[j] + i * pix + pix + pix;
                    for (int k = 0; k < steviloDaljic; k++) {
                        g.setColor(Color.BLUE);
                        g.drawLine(ri(x), ri(y), ri(x + dolzinaDaljice * pix), ri(y));
                        y += pix;
                    }
                }

                if (objava instanceof Oglas) {
                    g.setColor(Color.BLACK);
                    g.drawRect(ri(xZacetek + j * pix), ri(yZacetek[j] + i * pix + pix), ri(this.sirinaStolpca * pix), ri(objava.vrniVisino() * pix));
                    g.setColor(Color.RED);
                    g.drawLine(ri(xZacetek + j * pix), ri(yZacetek[j] + i * pix + pix), ri(xZacetek + j * pix + this.sirinaStolpca * pix), ri(yZacetek[j] + i * pix + pix + objava.vrniVisino() * pix));
                    g.drawLine(ri(xZacetek + j * pix), ri(yZacetek[j] + i * pix + pix + objava.vrniVisino() * pix), ri(xZacetek + j * pix + this.sirinaStolpca * pix), ri(yZacetek[j] + i * pix + pix));

                }
                xZacetek += this.sirinaStolpca * pix;
                yZacetek[j] += this.objave[i][j].vrniVisino() * pix;

            }

        }
    }

    public double pikNaCm(double wp, double hp) {
        int steviloObjavStolpec = 0;
        for (int i = 0; i < this.objave.length; i++) {
            steviloObjavStolpec = this.objave[i].length;
        }
        double sirinaStolpcev = this.sirinaStolpca * steviloObjavStolpec;
        double skupaj = sirinaStolpcev + (steviloObjavStolpec + 1) * 1;
        return wp / skupaj;
    }
}
