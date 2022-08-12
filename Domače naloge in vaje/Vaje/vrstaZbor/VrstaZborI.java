import java.util.*;

public class VrstaZborI {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

  int stVojakov = sc.nextInt();

  int [] visine = new int[stVojakov];

  for (int i = 0; i < stVojakov; i++) {
    visine[i] = sc.nextInt();
  }

  boolean vsajEden = false;

  for (int i = 0; i < visine.length; i++) {
    if (lokalnoPravilno(visine, i)) {
      System.out.println(i);
      vsajEden = true;
    }
  }
  if (!vsajEden)
    System.out.println("NOBEDEN");
  }

  public static boolean lokalnoPravilno(int [] t, int i) {
    return ((i == 0 || t[i - 1] <= t[i]) && (i == t.length - 1 || t[i] <= t[i + 1]));
  }
}
