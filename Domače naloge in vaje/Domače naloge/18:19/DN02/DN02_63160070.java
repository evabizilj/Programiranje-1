import java.util.*;

public class DN02_63160070 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int ukaz = sc.nextInt();
    int a = 0;
    int b = 0;

    switch(ukaz) {

      // Izpiši prvi element vhodnega zaporedja.
      case 1:
        int prvi = sc.nextInt();
        while (sc.hasNextInt()) {
          a = sc.nextInt();
        }
        System.out.println(prvi);
        break;

      // Izpiši zadnji element vhodnega zaporedja.
      case 2:
        while (sc.hasNextInt()) {
          a = sc.nextInt();
        }
        System.out.println(a);
        break;

      // Izpiši vsoto zadnjih dveh elementov vhodnega zaporedja.
      case 3:
        while (sc.hasNextInt()) {
          b = a;
          a = sc.nextInt();
        }
        System.out.println(a + b);
        break;

      // Izpiši dolžino prve čete vhodnega zaporedja
      case 4:
        int stevec = 0;
        while (sc.hasNextInt()) {
          b = a;
          a = sc.nextInt();
          if (b <= a)
            stevec++;
          else
            break;
          }
          System.out.println(stevec);
         break;

      // Izpiši največje število različnih elementov v isti četi.
      case 5:
        int razlicnih = 0;
        int max = 0;
        while (sc.hasNextInt()) {
          b = a;
          a = sc.nextInt();
          if (b <= a) {
            // smo še vedno v isti četi
            if (a != b)
              razlicnih++;
            if (razlicnih > max)
              max = razlicnih;
          } else {
            // prehod v novo četo
            razlicnih = 1;
          }
        }
        System.out.println(max);
        break;
      default:
        System.out.printf("Nepravilen vhod.\n");
        break;
      }
    }
  }
