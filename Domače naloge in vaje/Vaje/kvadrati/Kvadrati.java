import java.util.*;

public class Kvadrati {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    for (int i = a; a <= b; a++) {
      System.out.println(a * a);
    }
  }
}
