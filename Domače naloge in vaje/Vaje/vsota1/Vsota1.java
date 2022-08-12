import java.util.*;

public class Vsota1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(sestej(a, b));
  }

  public static int sestej(int x, int y) {
    return x + y;
  }
}
