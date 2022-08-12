import java.util.Scanner;

public class Smreka {

  private static final char ZVEZDICA = '*';
  private static final char PRESLEDEK = ' ';

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int visina = sc.nextInt();

    for (int i = 1; i <= visina; i++)
      piramida(i, visina);
  }

  private static void piramida(int visina, int zamik) {
    for (int a = 0; a < visina; a++) {
      int presledki = zamik - a - 1;
      int zvezdice = 2 * a + 1;
      for (int b = 0; b < presledki; b++)
        System.out.print(PRESLEDEK);
      for (int c = 0; c < zvezdice; c++)
        System.out.print(ZVEZDICA);
      System.out.println();
    }
  }
}
