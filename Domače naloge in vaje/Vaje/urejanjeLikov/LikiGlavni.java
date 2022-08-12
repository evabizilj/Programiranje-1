
import java.util.Scanner;

public class LikiGlavni {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // preberi like in jih shrani v tabelo
        Lik[] liki = preberi(sc);

        // preberi ukaz
        int ukaz = sc.nextInt();

        // ustrezno uredi tabelo likov
        Prim.Primerjalnik primerjalnik = ustvariPrimerjalnik(ukaz);
        uredi(liki, primerjalnik);

        // izpi"si urejeno tabelo likov
        izpisi(liki);
    }

    /** 
     * Prebere podatke o vseh likih z vhoda in vrne tabelo s prebranimi
     * podatki.
     */
    private static Lik[] preberi(Scanner sc) {
        int stLikov = sc.nextInt();

        Lik[] liki = new Lik[stLikov];
        for (int i = 0;  i < liki.length;  i++) {
            int vrsta = sc.nextInt();
            switch (vrsta) {
                case 1:
                    liki[i] = new Pravokotnik(sc.nextInt(), sc.nextInt());
                    break;

                case 2:
                    liki[i] = new Kvadrat(sc.nextInt());
                    break;

                case 3:
                    liki[i] = new Krog(sc.nextInt());
                    break;
            }
        }
        return liki;
    }

    /** 
     * Izpi"se podatke o likih v podani tabeli.
     */
    private static void izpisi(Lik[] liki) {
        for (int i = 0;  i < liki.length;  i++) {
            System.out.println(liki[i].toString());
        }
    }

    /**
     * Vrne primerjalnik glede na podani parameter:
     *    1 -- primerjalnik po tipu
     *    2 -- primerjalnik po plo"s"cini
     *    3 -- primerjalnik po obsegu
     *    4 -- primerjalnik najprej po tipu in nato po plo"s"cini
     *    5 -- primerjalnik najprej po plo"s"cini in nato po tipu
     *    6 -- primerjalnik najprej po plo"s"cini, nato po obsegu in nazadnje po tipu
     */
    private static Prim.Primerjalnik ustvariPrimerjalnik(int vrsta) {
        Prim.Primerjalnik poTipu = new Prim.PrimerjalnikTip();
        Prim.Primerjalnik poPloscini = new Prim.PrimerjalnikPloscina();
        Prim.Primerjalnik poObsegu = new Prim.PrimerjalnikObseg();

        switch (vrsta) {
            case 1:
                return poTipu;

            case 2:
                return poPloscini;

            case 3:
                return poObsegu;

            case 4:
                return new Prim.Kombinacija(poTipu, poPloscini);

            case 5:
                return new Prim.Kombinacija(poPloscini, poTipu);

            case 6:
                return new Prim.Kombinacija(new Prim.Kombinacija(poPloscini, poObsegu), poTipu);

            default:
                throw new RuntimeException("Neveljaven ukaz!");
        }
    }

    /**
     * Z uporabo algoritma navadnega vstavljanja nara"s"cajo"ce uredi podano
     * tabelo.  Na podlagi te metode napi"site metodo za urejanje likov.
     */
    private static void uredi(int[] t) {
        for (int i = 1;  i < t.length;  i++) {
            int trenutni = t[i];
            int j = i;
            while (j > 0 && trenutni < t[j - 1]) {
                t[j] = t[j - 1];
                j--;
            }
            t[j] = trenutni;
        }
    }

    /**
     * Uredi podano tabelo glede na podani primerjalnik.
     */
    private static void uredi(Lik[] liki, Prim.Primerjalnik primerjalnik) {
        for (int i = 1;  i < liki.length;  i++) {
            Lik trenutni = liki[i];
            int j = i;
            while (j > 0 && primerjalnik.jePred(trenutni, liki[j - 1])) {
                liki[j] = liki[j - 1];
                j--;
            }
            liki[j] = trenutni;
        }
    }
}
