import java.util.*;

class KlubMatematicnihPlesalcev {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int moski = sc.nextInt();
    int zenske = sc.nextInt();
    int stevilo = sc.nextInt();
    int index = 1;

    for (int i = 1; i <= moski; i++) {
      for (int j = 1; j <= zenske; j++) {
        if (gcd(i, j) == stevilo) {
          System.out.printf("[%d] %d + %d\n", index, i, j);
          index++;
        }
      }
    }
  }
  public static int gcd (int a, int b) {
    if (a % b == 0)
      return b;
    return gcd (b, (a % b));
  }
}
