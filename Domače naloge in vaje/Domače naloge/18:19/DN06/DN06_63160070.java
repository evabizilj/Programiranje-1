import java.util.*;

public class DN06_63160070 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
  
    int stVrstic = sc.nextInt();
    int stStolpcev = sc.nextInt();

    int zemljevid[][] = new int[stVrstic][stStolpcev];

    // branje zemljevida
    for (int i = 0; i < stVrstic; i++) {
        for (int j = 0; j < stStolpcev; j++) {
            zemljevid[i][j] = sc.nextInt();
        }
    }

    int ukaz = sc.nextInt();

    int steviloDrzav = izracunajSteviloDrzav(zemljevid, stVrstic, stStolpcev);
    int sosednosti[][] = new int[steviloDrzav + 1][steviloDrzav + 1];
    int obale[] = new int[steviloDrzav + 1];

    switch (ukaz) {
        // Stevilo drzav na zemljevidu.
        case 1:
            System.out.println(izracunajSteviloDrzav(zemljevid, stVrstic, stStolpcev));
            break;

        // Stevilo celic na morju.
        case 2: 
            System.out.println(izracunajSteviloCelicNaMorju(zemljevid, stVrstic, stStolpcev));
            break;
        
        /* 
            Izpisi D vrstic, pri cemer naj bo v i-ti vrstici zapisana dolzina obale i-te drzave.
            Dolzina obale države je stevilo celic te države, ki pripadajo obali, 
            celica pa pripada obali, ce vsaj na eni od svojih stirih stranic meji na morje. 
            Ker je celotno obmocje obdano z morjem, so vse kopne celice na robu obmocja del obale. 
        */

        case 3:
            izracunajDolzinoObale(zemljevid, stVrstic, stStolpcev, obale, steviloDrzav);
            break;

        /*
            Rekli bomo, da je drzava b soseda države a, ce vsaj ena celica države b meji 
            na neko celico države a.
            Ukaz 4 izpolnite tako, da v prvi vrstici izpisete zaporedno 
            stevilko drzave z najvec sosednjimi drzavami, v drugi pa stevilo sosed 
            te drzave. Ce obstaja več drzav z najvec sosedami, izberite tisto z 
            najmanjso zaporedno številko.
        */

        case 4:
            izracunajSteviloSosed(zemljevid, stVrstic, stStolpcev, sosednosti, steviloDrzav);
            break;

        default:
            break;

        }
    }

    public static int izracunajSteviloDrzav(int zemljevid[][], int stVrstic, int stStolpcev) {
        int naj = 0;
        for (int i = 0; i < stVrstic; i++) {
            for (int j = 0; j < stStolpcev; j++) {
                int drzava = zemljevid[i][j];
                if (drzava > naj)
                    naj = drzava;
            }
        }
        return naj;
    }

    public static int izracunajSteviloCelicNaMorju(int zemljevid[][], int stVrstic, int stStolpcev) {
        int stevec = 0;
        for (int i = 0; i < stVrstic; i++) {
            for (int j = 0; j < stStolpcev; j++) {
                if (zemljevid[i][j] == 0)
                    stevec++;
            }
        }
        return stevec;
    }

    public static void izracunajDolzinoObale(int zemljevid[][], int stVrstic, int stStolpcev, int obale[], int steviloDrzav) {
        for (int i = 0; i < stVrstic; i++) {
            for (int j = 0; j < stStolpcev; j++) {
                if (zemljevid[i][j] == 0)
                    continue;
                
                int drzava = zemljevid[i][j];
                
                if (i == 0 || i == stVrstic - 1 || j == 0 || j == stStolpcev - 1) {
                    obale[drzava]++;
                    continue;
                }

                if (zemljevid[i - 1][j] == 0 || zemljevid[i + 1][j] == 0 || zemljevid[i][j - 1] == 0|| zemljevid[i][j + 1] == 0) {
                    obale[drzava]++;
                    continue;
                }
            }
        }
        for (int i = 1; i <= steviloDrzav; i++) {
            System.out.println(obale[i]);
        }
    }

    public static void izracunajSteviloSosed(int zemljevid[][], int stVrstic, int stStolpcev, int sosednosti[][], int steviloDrzav) {
       // napolni tabelo sosednosti
        int steviloSosed = 0;
        int maxSosed = 0;
        int index = 0;
        for (int i = 0; i < stVrstic; i++) {
           for (int j = 0; j < stStolpcev; j++) {
                if (i + 1 < stVrstic)
                    sosednosti[zemljevid[i][j]][zemljevid[i + 1][j]] = 1;
                if (i > 0) 
                    sosednosti[zemljevid[i][j]][zemljevid[i - 1][j]] = 1;
                if (j + 1 < stStolpcev)
                    sosednosti[zemljevid[i][j]][zemljevid[i][j + 1]] = 1;
                if  (j > 0)
                    sosednosti[zemljevid[i][j]][zemljevid[i][j - 1]] = 1;
           }
        }
        // stevilo razlicnih drzav za sosede
        int j = 1;
        for (int i = 1; i < steviloDrzav; i++) {
            steviloSosed = 0;
            for (j = 1; j < steviloDrzav; j++) {
                steviloSosed += sosednosti[i][j];
            }
            if (steviloSosed > maxSosed) {
                index = i;
                maxSosed = steviloSosed;
            }
        }
        System.out.println(index);
        System.out.println(maxSosed);
    }
}

