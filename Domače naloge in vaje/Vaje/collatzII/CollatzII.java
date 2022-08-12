import java.util.*;

public class CollatzII {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int min = sc.nextInt();
    int max = sc.nextInt();
    int maxLength = 0;
    int maxNumber = 0;

    for (int i = min; i <= max; i++) {
      if (collatz(i) > maxLength) {
        maxLength = collatz(i);
        maxNumber = i;
      }
    }

    System.out.println(maxNumber);
    System.out.println(maxLength);
  }

  //  Collatz Sequence
  public static int collatz(int number) {
    int counter = 1;
    while (number > 1) {
      if (number % 2 == 0) {
        number /= 2;
        counter++;
      } else {
        number = number * 3 + 1;
        counter++;
      }
    }
    return counter;
  }
}
