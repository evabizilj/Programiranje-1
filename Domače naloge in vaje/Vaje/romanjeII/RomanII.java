import java.util.*;

public class RomanII {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int celotnaPot = sc.nextInt();
    int potDan = sc.nextInt();

    int dan = 1;

    while (celotnaPot > potDan) {
      System.out.printf("%d. dan: %d -> %d (prehodil %d)\n" , dan++, celotnaPot, celotnaPot - potDan, potDan);
      celotnaPot -= potDan;
    }
     System.out.printf("%d. dan: %d -> %d (prehodil %d)\n" , dan++, celotnaPot, 0, celotnaPot);
  }
}
