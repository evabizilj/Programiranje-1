import java.util.*;

public class CollatzovoZaporedje {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int stevilo = sc.nextInt();
    System.out.println(collatz(stevilo));
  }
  public static int collatz(int stevilo) {
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
