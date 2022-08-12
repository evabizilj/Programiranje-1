import java.util.Scanner;

public class MravljaI {

// Vrne stevilo poti od zgornjega levega do spodnjega desnega kota za steno s podano visino in sirino.
  private static long stPoti(int visina, int sirina) {
  // na steni 1 x nekaj ali nekaj x 1 imamo eno samo pot
    if (visina <= 1 || sirina <= 1)
      return 1;
  // sicer sestejemo stevilo moznih poti, ki jih imamo na obeh podstenah
    return stPoti(visina - 1, sirina) + stPoti(visina, sirina - 1);
  }

  // memoizacija -- pomnenje ze izracunanih vrednosti
  private static long stPotiMemo(int visina, int sirina, long[][] memo) {
  // na steni 1 x nekaj ali nekaj x 1 imamo eno samo pot
    if (visina <= 1 || sirina <= 1)
      return 1;

  // smo vrednost za steno visina x sirina morda ze izracunali?!
    if (memo[visina][sirina] > 0)
      return memo[visina][sirina];
    if (memo[sirina][visina] > 0)
      return memo[sirina][visina];
  // ... ce nismo, izracunamo in shranimo, saj jo bomo morda sekdaj potrebovali
    memo[visina][sirina] =  stPotiMemo(visina - 1, sirina, memo) + stPotiMemo(visina, sirina - 1, memo);
  return memo[visina][sirina];
  }

  public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

  int visina = sc.nextInt();
  int sirina = sc.nextInt();


  int m = Math.max(visina, sirina) + 1;
  long[][] memo = new long[m][m];
  System.out.println(stPotiMemo(visina, sirina, memo));
  }
}
