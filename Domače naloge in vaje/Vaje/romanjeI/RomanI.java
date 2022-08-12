import java.util.*;

public class RomanI {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int celotnaPot = sc.nextInt();
    int potDan = sc.nextInt();

    System.out.println(celotnaPot);

    while (celotnaPot > potDan) {
      celotnaPot -= potDan;
      System.out.println(celotnaPot);
    }
  }
}
