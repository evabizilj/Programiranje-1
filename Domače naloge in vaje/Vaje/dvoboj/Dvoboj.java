import java.util.*;

public class Dvoboj {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int seme = sc.nextInt();
    Random generator = new Random(seme);
    int steviloPartij = sc.nextInt();
    int oAnja = sc.nextInt();
    int oBojan = sc.nextInt();
    int zmageAnja = 0;
    int zmageBojan = 0;

    while (steviloPartij != zmageAnja && steviloPartij != zmageBojan) {
      int nak = generator.nextInt(100);
      if (nak < oAnja) { // zmaga Anja
        System.out.print("A");
        zmageAnja++;
      } else if (nak < (oAnja + oBojan)) { // zmaga Bojan
        System.out.print("B");
        zmageBojan++;
      } else {
        System.out.print("-");
        // neodločeno
      }
    }
    System.out.println();
  }
}
