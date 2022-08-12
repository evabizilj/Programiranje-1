import java.util.*;

class Zgoscenke {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int prazneZgoscenke = sc.nextInt();
    int kapZgoscenke = sc.nextInt();
    int trenutniPodatki = 0;
    int zgoscenka = 1;

    while (sc.hasNextInt() && (prazneZgoscenke >= zgoscenka)) {
      int velikostDatoteke = sc.nextInt();
      trenutniPodatki += velikostDatoteke;
      if (trenutniPodatki > kapZgoscenke) {
        trenutniPodatki = velikostDatoteke;
        zgoscenka++;
      }
      if (zgoscenka > prazneZgoscenke) {
        break;
      }
      System.out.printf("%d EP -> zgoscenka %d (%d EP)\n", velikostDatoteke, zgoscenka, trenutniPodatki);
    }
  }
}
