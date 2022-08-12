import java.util.*;

public class RomanIII {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int celotnaPot = s.nextInt();
    int potNaDan = s.nextInt();
    int potManj = s.nextInt();
    int i = 1;

    while (celotnaPot > 0 && potNaDan > 0) {
        if (celotnaPot < potNaDan) {
          potNaDan = celotnaPot;
        }
        System.out.printf("%d. dan: %d -> %d (prehodil %d)\n", i++, celotnaPot, celotnaPot - potNaDan, potNaDan);
        celotnaPot -= potNaDan;
        potNaDan -= potManj;
    }
  }
}
