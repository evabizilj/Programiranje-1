
import java.awt.*;

/**
 * Stolpci s povezovalno "crto in napisi.
 */
public class Stolpci extends Platno {

    public static void main(String[] args) {
        // V odvisnosti od argumentov ukazne vrstice bodisi ustvari okno in
        // plo"s"co ali pa pripravi sliko v pomnilniku, na katero je mo"zno
        // risati.  S stali"s"ca izdelave na"sega programa je to popolnoma
        // vseeno.

        int[] podatki = {150, 70, 120, 190, 60, 130, 40, 100, 80, 60};
        //int[] podatki = {5};
        //int[] podatki = {1, 1, 1};
        Stolpci stolpci = new Stolpci(podatki);
        stolpci.sproziRisanje(args);
    }

    // podatki, ki dolo"cajo vi"sine stolpcev
    private int[] podatki;

    public Stolpci(int[] podatki) {
        this.podatki = podatki;
    }

    /**
     * Nari"se sliko na platno (zaslon ali slikovno datoteko).  To metodo
     * pokli"ce ogrodje, ko je "cas zanjo.
     * @param g objekt, ki nam omogo"ca risanje
     * @param wp "sirina platna
     * @param hp vi"sina platna
     */
    protected void narisi(Graphics2D g, double wp, double hp) {
        double sirinaStolpca = sirinaStolpca(wp, hp);
        double x = 0.0;
        FontMetrics pisava = g.getFontMetrics();
        int visinaPisave = pisava.getAscent();

        for (int i = 0; i < podatki.length;  i++) {
            double visinaStolpca = visinaStolpca(i, wp, hp);
            double y = hp - visinaStolpca;

            // STOLPCI
            g.setColor(Color.ORANGE);
            g.fillRect(ri(x), ri(y), ri(sirinaStolpca), ri(visinaStolpca));
            g.setColor(Color.RED);
            g.drawRect(ri(x), ri(y), ri(sirinaStolpca), ri(visinaStolpca));

            // CRTE
            if (i > 0) {
                double[] sredinaLevo = sredinaVrha(i - 1, wp, hp);
                double[] sredinaDesno = sredinaVrha(i, wp, hp);

                g.setColor(Color.BLUE);
                g.drawLine(ri(sredinaLevo[0]), ri(sredinaLevo[1]), ri(sredinaDesno[0]), ri(sredinaDesno[1]));
            }

            // STEVILKE
            String napis = Integer.toString(i + 1);
            double sirinaNapisa = pisava.stringWidth(napis);
            double xNapis = x + (sirinaStolpca - sirinaNapisa) / 2;
            double yNapisSpodnjiRob = hp - visinaPisave;
            g.setColor(Color.BLACK);
            g.drawString(napis, ri(xNapis), ri(yNapisSpodnjiRob));

            x += sirinaStolpca;
        }
    }

    public double sirinaStolpca(double wp, double hp) {
        return wp / this.podatki.length;
    }

    public double visinaStolpca(int ixStolpec, double wp, double hp) {
        return this.podatki[ixStolpec] * (hp / maksimum(podatki));
    }

    public double maksimum (int[] podatki) {
        int maksimum = 0;
        for (int i = 0; i < podatki.length; i++) {
            if (podatki[i] > maksimum)
                maksimum = podatki[i];
        }
        return maksimum;
    }

    public double[] sredinaVrha(int ixStolpec, double wp, double hp) {
        double wStolpec = sirinaStolpca(wp, hp);
        double x = ixStolpec * wStolpec + wStolpec / 2; 
        double y = hp - visinaStolpca(ixStolpec, wp, hp);
        return new double[] {x, y};
    }
}
