import java.util.*;

public class DN00_63160070 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int candies = sc.nextInt();
    int friends = sc.nextInt();

    int each = candies / friends;
    int remainder = candies - friends * each;
    System.out.println(each);
    System.out.println(remainder);

  }
}
