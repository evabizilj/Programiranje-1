import java.util.*;

public class DN01_63160070 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int steviloPeriod = sc.nextInt();
    int valovnaDolzina = sc.nextInt();
    int amplituda = sc.nextInt();
    int fazniZamik = sc.nextInt();
    int polovicaValovne = valovnaDolzina / 2;
    int dolzinaVrstice = polovicaValovne * 2 * steviloPeriod;

    izpisiVrstico(dolzinaVrstice, polovicaValovne, fazniZamik, '-', '+', ' ');
    for (int i = 0; i < amplituda - 1; i++)
      izpisiVrstico(dolzinaVrstice, polovicaValovne, fazniZamik, ' ', '|', ' ');
    izpisiVrstico(dolzinaVrstice, polovicaValovne, fazniZamik, ' ', '+', '-');
}
  // Vsaka vrstica je oblike A A B C C B ...
  public static void izpisiVrstico(int dolzinaVrstice, int polovicaValovne, int fazniZamik, char a, char b, char c) {
    for (int j = fazniZamik + 1; j <= dolzinaVrstice + fazniZamik; j++) {
      int modJ = j % (polovicaValovne * 2);
      if ((modJ < polovicaValovne) && (modJ > 0))
        System.out.print(a);
      else if (modJ % polovicaValovne == 0)
        System.out.print(b);
      else
        System.out.print(c);
    }
    System.out.println();
  }
}
