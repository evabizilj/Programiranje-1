import java.util.*;
public class ZgoscenkeI {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int stZgoscenk = sc.nextInt();
    int kapacitetaZgoscenk = sc.nextInt();

    int[] zasedenosti = new int[stZgoscenk];

    while (sc.hasNextInt()) {
      int velikostDatoteke = sc.nextInt();
      int indeksIzbraneZgoscenke = indeksMinimuma(zasedenosti);

      if (zasedenosti[indeksIzbraneZgoscenke] + velikostDatoteke <= kapacitetaZgoscenk)
          zasedenosti[indeksIzbraneZgoscenke] += velikostDatoteke;
      else
        break;

      System.out.printf("%d EP -> zgoscenka %d %s%n", velikostDatoteke, indeksIzbraneZgoscenke + 1, Arrays.toString(zasedenosti));
    }
  }

  public static int indeksMinimuma(int[] tabela) {
    int iMin = 0;
    for (int i = 1; i < tabela.length; i++) {
      if (tabela[i] < tabela[iMin])
        iMin = i;
    }
    return iMin;
  }
}
