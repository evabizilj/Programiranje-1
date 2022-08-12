import java.util.*;

public class KleptomankaAnka {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int d = sc.nextInt();
    int stevec = 0;


    for (int a = 0; a <= 9; a++) {
      for (int b = 0; b <= 9; b++) {
        for (int c = 0; c <= 9; c++) {
          if ((a % 2 != 0) && (b > m) && (c % d == 0)) {
            System.out.printf("%d-%d-%d\n", a, b, c);
            stevec++;
          }
        }
      }
    }
    System.out.println(stevec);
  }
}
