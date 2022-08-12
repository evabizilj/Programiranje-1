import java.util.*;

public class IzpisStevk {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long stevilo = sc.nextLong();

    izpisStevk(stevilo);
  }

  public static void izpisStevk(long stevilo) {
    while (stevilo > 0) {
      long stevka = stevilo % 10;
      stevilo /= 10;
      System.out.println(stevka);
    }
  }
}
