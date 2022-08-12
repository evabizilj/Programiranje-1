import java.util.*;

public class DN07_63160070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stPostaj = sc.nextInt();
        int[] casCakanja = new int[stPostaj];
        int[] potovalniCasiA = new int[stPostaj];
        int[] potovalniCasiB = new int[stPostaj];
        int sumPotovalniCasi = 0;
        int maxPotovalniCasA = 0;
        int maxPotovalniCasB = 0;
        int skupajCakanje = 0;

        for (int i = 1; i < potovalniCasiA.length; i++) {
            potovalniCasiA[i] = sc.nextInt();
            sumPotovalniCasi += potovalniCasiA[i];
        }

        potovalniCasiB = Arrays.copyOf(potovalniCasiA, potovalniCasiA.length);
        reverse(potovalniCasiB, 1, potovalniCasiB.length - 1);

        int stPoti = sc.nextInt();
        int minCakanja = Integer.MAX_VALUE;
    
        for (int j = 0; j < stPoti; j++) {
            casCakanja[0] = 0;
            minCakanja = Integer.MAX_VALUE;
            int zacA = sc.nextInt();
            int zacB = sc.nextInt();
            maxPotovalniCasA = sumPotovalniCasi + zacA;
            maxPotovalniCasB = sumPotovalniCasi + zacB;

            int[] vlakA = new int[stPostaj];
            vlakA[0] = zacA;
            for (int i = 1; i < stPostaj; i++) {
                vlakA[i] += vlakA[i - 1] + potovalniCasiA[i];
            }

            int[] vlakB = new int[stPostaj];
            vlakB[0] = zacB;
            for (int i = 1; i < stPostaj; i++) {
                vlakB[i] += vlakB[i - 1] + potovalniCasiB[i];
            }

            reverse(vlakB, 0, vlakB.length - 1);

            if (maxPotovalniCasA < zacB || maxPotovalniCasB < zacA)
                minCakanja = 0;
            else {
                for (int i = 0; i < stPostaj; i++) {
                    casCakanja[i] = Math.abs(vlakB[i] - vlakA[i]);
                    if (i < stPostaj - 1) {
                        casCakanja[i + 1] = Math.abs(vlakB[i + 1] - vlakA[i + 1]);
                        if (casCakanja[i] < casCakanja[i + 1]) {
                            minCakanja = casCakanja[i];
                            break;
                        }
                        else {
                            if (minCakanja > casCakanja[i])
                                minCakanja = casCakanja[i];
                        }
                    } else {
                        if (minCakanja > casCakanja[i]) {
                            minCakanja = casCakanja[i];
                        }
                    }
                }
            }
            skupajCakanje += minCakanja;
        }
        System.out.print(skupajCakanje);
    }

    public static void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
} 