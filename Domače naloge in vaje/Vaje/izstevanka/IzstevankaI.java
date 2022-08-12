import java.util.Scanner;

public class IzstevankaI {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int stOtrok = sc.nextInt();
    int stBesed = sc.nextInt();

    // preberi imena otrok
    String[] otroci = new String[stOtrok];
    for (int i = 0; i < stOtrok; i++) {
      otroci[i] = sc.next();
    }

    while (stOtrok > 1) {
      int izpade = (stBesed % stOtrok);
			if (izpade == 0)
				izpade = stOtrok - 1;
			else
				izpade--;

      System.out.println(otroci[izpade]);
			otroci[izpade] = "";
			for (int k = 1; k < stOtrok; k++) {
        if (otroci[k - 1] == "") {
					otroci[k - 1] = otroci[k];
					otroci[k] = "";
				}
			}
			stOtrok--;
    }
  }
}

/*
// število krogov izštevanke (v vsakem krogu nekoga izločim)
int stKrogov = stOtrok - 1;

// število otrok, ki še niso izpadli
int stOtrokVIgri = stOtrok;

// simulacija izstevanke
for (int krog = 0; krog < stKrogov; krog++) {
  // ugotovi, kdo izpade
  int indeksIzpadlega = kdoIzpade(stOtrokVIgri, stBesed);
  // izpiši ime izpadlega otroka
  System.out.println(otroci[indeksIzpadlega]);
  // izloči izpadlega otroka iz igre
  izloci(otroci, indeksIzpadlega, stOtrokVIgri);
  stOtrokVIgri--;
}
}

private static int kdoIzpade(int stOtrok, int stBesed) {
  return (stBesed - 1) % stOtrok;
}

// Izloči element z indeksom 'ix' iz tabele 't' tako, da elemente tabele
//  t DESNO od indeksa 'ix' pomakne za eno mesto v levo.

private static void izloci(String[] t, int ix, int dolzina) {
for (int i = ix; i > dolzina; i++) {
t[i] = t[i + 1];
}
}
}
*/
