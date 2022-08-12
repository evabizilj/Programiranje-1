import java.util.*;
public class DN03_63160070 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int stMesecevNaLeto = sc.nextInt();
    int stDniNaMesec = sc.nextInt();
    int stDniNaTeden = sc.nextInt();
    int prostiDan = sc.nextInt();
    int praznik = sc.nextInt();

    int zacMesec = sc.nextInt();
    int zacLeto = sc.nextInt();
    int konMesec = sc.nextInt();
    int konLeto = sc.nextInt();

    int leto = 1;
    int mesec = 1;
    int zamik = 0;
    int dan = 0;
    int steviloDni = 0;

    if (zacLeto == 1 && zacMesec > 1) {
      steviloDni = stDniNaMesec * (zacMesec - 1);
    }
    else
      steviloDni = (zacLeto - 1) * stMesecevNaLeto * stDniNaMesec + (zacMesec - 1) * stDniNaMesec;

    while (leto <= konLeto && (leto < konLeto || mesec <= konMesec)) {
      // izpis meseca
      if (leto >= zacLeto && (leto > zacLeto || mesec >= zacMesec)) {
        System.out.printf("%d/%d\n", mesec, leto);
        for (int j = 0; j < zamik; j++) {
          System.out.print("     ");
        }
        int indexDneva = zamik + 1; // 1. dan v mesecu
        for (int i = 1; i <= stDniNaMesec; i++) {
          if ((prostiDan <= stDniNaTeden) && ((indexDneva % prostiDan) == 0) && (((i + steviloDni) % praznik == 0)))
            System.out.printf("%4d*", i);
          else if (prostiDan <= stDniNaTeden && (indexDneva % prostiDan) == 0) // prosti dan
            System.out.printf("%4dx", i);
          else if ((i + steviloDni) % praznik == 0)
           System.out.printf("%4d+", i);
          else
            System.out.printf("%4d_", i);
          if ((i + zamik) % stDniNaTeden == 0 || stDniNaMesec == i)
            System.out.println();
          if (indexDneva == stDniNaTeden)
            indexDneva = 0;
          indexDneva++;
        }
        steviloDni += stDniNaMesec;
        dan += stDniNaMesec;
      }
      // logika povecevanja meseca in leta
      ++mesec;
      if (mesec > stMesecevNaLeto) {
        mesec = 1;
        ++leto;
      }
      // izracunaj zamik naslednjega meseca
      for (int dni = stDniNaMesec; dni > 0;) {
        int teden = stDniNaTeden - zamik;
        zamik = 0;
        if (teden > dni) { // zadnji teden
          zamik = dni;
        }
        dni -= teden;
      }
    }
  }
}
