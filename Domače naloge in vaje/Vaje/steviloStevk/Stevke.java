import java.util.*;

class Stevke {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int stevilo = sc.nextInt();
    int stevec = 0;

    if (stevilo == 0) {
      stevec = 1;
    }
    while (stevilo > 0) {
      stevilo /= 10;
      stevec++;
    }
    System.out.println(stevec);
  }
}
