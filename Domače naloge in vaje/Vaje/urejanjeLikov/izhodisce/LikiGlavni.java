
import java.util.Scanner;

public class LikiGlavni {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // preberi like in jih shrani v tabelo
        Lik[] liki = preberi(sc);

        // preberi ukaz
        int ukaz = sc.nextInt();

        // ustrezno uredi tabelo likov
        // ...

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
}
