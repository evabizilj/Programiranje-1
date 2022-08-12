import java.util.*;

public class DN05_63160070 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int steviloOseb = sc.nextInt();
    int visine[] = new int[steviloOseb];
    long razdalje[] = new long[steviloOseb];
    long vsota = 0;
    for (int i = 0; i < visine.length; i++) {
      visine[i] = sc.nextInt();
    }
     razdalje[0] = 1;
     for (int i = 0; i < steviloOseb; ++i) { // osebe
        vsota += izracunajRazdaljo(i, visine, razdalje);
     }
     System.out.println(vsota);
  }
  public static long izracunajRazdaljo(int i, int visine[], long razdalje[]) {
    long stevec = 1;
    int j = i - 1;
    while (j >= 0 && visine[i] >= visine[j]) {
      stevec += razdalje[j];
      j -= razdalje[j];
    }
    razdalje[i] = stevec;
    return stevec;
  }
}