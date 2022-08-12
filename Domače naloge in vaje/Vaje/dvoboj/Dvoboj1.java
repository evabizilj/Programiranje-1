
import java.util.Scanner;
import java.util.Random;

public class Dvoboj {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int seme = sc.nextInt();
        int ciljnoStZmag = sc.nextInt();
        int verjAnja = sc.nextInt();
        int verjBojan = sc.nextInt();
        
     
        
        Random generator = new Random(s);
        int stAnjinihZmag = 0; // števec Anjinih zmah
        int stBojanovihZmag = 0; // števec Bojanovih zmag
        
        while (stAnjinihZmag < ciljnoStZmag && stBojanovihZmag < ciljnoStZmag) { // odigrama eno partijo
            
            int izid = simulirajPartijo(generator, verjAnja, verjBojan);
            
            switch (izid) {
                case 1:
                    System.out.print("A");
                    stAnjinihZmag++;
                    break;
                    
                case 2:
                    System.out.print("B");
                    stBojanovihZmag++;
                    break;
                    
                case 0:
                    System.out.print("-");
                    break;
            }
        
            }
        System.out.print();
        
        private static int simulirajPartijo(Random generator, int verjAnja, int verjBojan) {
        
            int nak = generator.nextInt(100); // naključno število med 0 - 99
            if (nak < verjAnja) {
                // zmaga Anja
                return 1;
                
            }
            if (nak < verjAnja + verjBojan) {
                // zmaga Bojan
                return 2;
            }
            // remi
            return 0;
        }
    }
}

        
        

