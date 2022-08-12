import java.util.*;

class Dvoboj2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int s = sc.nextInt();
    int steviloPartij = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int zmagaA = 0;
    int zmagaB = 0;

    Random generator = new Random(s);

  while (steviloPartij != zmagaA && steviloPartij != zmagaB) {
    int nak = generator.nextInt(100);

    if (nak < a) {
      System.out.print("A");
      zmagaA++;
    }
    else if (nak < (a + b)) {
      System.out.print("B");
      zmagaB++;
    }
    else
      System.out.print("-");
    }
    System.out.println();
  }
}
