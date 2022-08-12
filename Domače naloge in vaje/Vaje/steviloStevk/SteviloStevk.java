import java.util.*;

public class SteviloStevk {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int stevilo = sc.nextInt();

    System.out.println(izracunajSteviloStevk(stevilo));
  }

  public static int izracunajSteviloStevk(int stevilo) {
    int stevke = 0;
    while (stevilo > 0) {
      stevke++;
      stevilo /= 10;
    }
    return stevke;
  }
}
