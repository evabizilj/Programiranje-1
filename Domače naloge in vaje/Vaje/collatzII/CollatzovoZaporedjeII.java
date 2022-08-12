import java.util.*;

public class CollatzovoZaporedjeII {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int najDolzina = 0;
    int najStevilo = 0;

    for (int i = a; i <= b; i++) {
      if (collatzCleni(i) > najDolzina) {
        najDolzina = collatzCleni(i);
        najStevilo = i;
      }
    }
    
    System.out.println(najStevilo);
    System.out.println(najDolzina);
  }
  public static int collatzCleni(int stevilo) {
    int stevec = 1;
    while (stevilo > 1) {
      if (stevilo % 2 == 0) {
        stevilo /= 2;
        stevec++;
      } else {
        stevilo = stevilo * 3 + 1;
        stevec++;
      }
    }
    return stevec;
  }
}
