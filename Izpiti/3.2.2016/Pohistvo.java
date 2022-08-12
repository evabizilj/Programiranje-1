
// Testni primeri:
// J4, S16--S20: ena omara na stolpec, vse omare enako visoke, enota vi"sine = piksel
// J5, S21--S25: en predalnik na stolpec, vsi predalniki enako visoki, enota vi"sine = piksel
// J6, S26--S30: ena omara na stolpec, enota vi"sine = piksel
// J7, S31--S35: en predalnik na stolpec, enota vi"sine = piksel
// J8, S36--S40: ena omara na stolpec

import java.awt.*;
import java.util.*;

public class Pohistvo extends Platno {
  private static final double ODMIK_ROCAJA = 10.00;
  private static final double PREMER_ROCAJA = 10.00;


    //-------------------------------------------------------------------------
    // Objekt tega razreda predstavlja kos pohi"stva.
    //-------------------------------------------------------------------------
    public static abstract class Kos {
        private int visina;   // vi"sina kosa v relativnih enotah

        protected Kos(int visina) {
            this.visina = visina;
        }

        public int vrniVisino() {
            return this.visina;
        }

        public abstract void narisiDodatke(Graphics2D g, double x, double y, double w, double h);
    }

    //-------------------------------------------------------------------------
    // Objekt tega razreda predstavlja omaro.
    //-------------------------------------------------------------------------
    public static class Omara extends Kos {

        public Omara(int visina) {
            super(visina);
        }

        public void narisiDodatke(Graphics2D g, double x, double y, double w, double h) {
          g.setColor(Color.RED);
          g.fillOval(ri(x + ODMIK_ROCAJA), ri (y + (h - PREMER_ROCAJA) / 2.0), ri(PREMER_ROCAJA), ri(PREMER_ROCAJA));
        }
    }

    //-------------------------------------------------------------------------
    // Objekt tega razreda predstavlja predalnik.
    //-------------------------------------------------------------------------
    public static class Predalnik extends Kos {

        private int stPredalov;   // "stevilo predalov

        public Predalnik(int visina, int stPredalov) {
            super(visina);
            this.stPredalov = stPredalov;
        }

        public int vrniStPredalov() {
            return this.stPredalov;
        }

        public void narisiDodatke(Graphics2D g, double x, double y, double w, double h) {
          double hPredal = h / this.stPredalov;
          double yp = y;

          for (int i = 0; i < this.stPredalov; i++) {
            if (i > 0) {
              g.setColor(Color.BLUE);
              g.drawLine(ri(x), ri(y), ri(x + w), ri(yp));
            }
            g.setColor(Color.RED);
            g.fillOval(ri(x + (w - PREMER_ROCAJA) / 2.0), ri(yp + (hPredal - PREMER_ROCAJA) / 2.0), ri(PREMER_ROCAJA), ri(PREMER_ROCAJA));
            yp += hPredal;
          }
        }
      }

    //-------------------------------------------------------------------------
    public static void main(String[] args) {
        Kos[][] kosi = {
            { new Omara(2), new Predalnik(1, 1) },
            { new Predalnik(2, 3), new Omara(3) },
            { new Omara(3), new Predalnik(1, 2) },
            { new Predalnik(3, 5) }
        };

        Pohistvo pohistvo = new Pohistvo(kosi);
        pohistvo.sproziRisanje(args, "Pohistvo");
    }

    //-------------------------------------------------------------------------
    // Tabela kosov pohi"stva.
    // kosi[i]: kosi pohi"stva v stolpcu z indeksom i
    //-------------------------------------------------------------------------
    private Kos[][] kosi;

    //-------------------------------------------------------------------------
    public Pohistvo(Kos[][] kosi) {
        this.kosi = kosi;
    }

    //-------------------------------------------------------------------------
    protected void narisi(Graphics2D g, double wp, double hp) {
      double x = 0.0;
      double wKos = this.sirinaKosa(wp, hp);
      double hEnota = this.visinaEnote(wp, hp);

      for (int i = 0; i < this.kosi.length; i++) {
        double y = hp;
        for (int j = 0; j < this.kosi[i].length; j++) {
          Kos kos = this.kosi[i][j];
          double hKos = kos.vrniVisino() * hEnota;
          y -= hKos;
          g.setColor(Color.BLACK);
          g.drawRect(ri(x), ri(y), ri(wKos), ri(hKos));
          kos.narisiDodatke(g, x, y, wKos, hKos);
        }
        x += wKos;
      }
    }

    //-------------------------------------------------------------------------
    public double sirinaKosa(double wp, double hp) {
      return wp / this.kosi.length;
    }

    //-------------------------------------------------------------------------
    public double visinaEnote(double wp, double hp) {
      int max = 0;
      for (int i = 0; i < this.kosi.length; i++) {
        int visina = vsotaVisin(this.kosi[i]);
        if (visina > max)
          max = visina;
      }
      return hp / max;
    }

    private static int vsotaVisin(Kos[] kosi) {
      int vsota = 0;
      for (int i = 0; i < kosi.length; i++)
        vsota += kosi[i].vrniVisino();
      return vsota;
    }
}
