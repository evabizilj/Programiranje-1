import java.util.*;

public class Prva {

    public static int naslednjaPotenca2(int n) {
        int potenca = 1;
        while (potenca <= n) {
            potenca *= 2;
        }
        return potenca;
    }

    public static int sosedjeZRazmikom(int[] t, int r) {
        int stevec = 0;
        for (int i = 0; i < t.length - 1; i++) {
            if (Math.abs(t[i] - t[i + 1]) == r)
                stevec++;
        }
        return stevec++;
    }

    public static int[] vsote(int[] t) {
        int[] tabela = new int[3];
        for (int i = 0; i < t.length; i++) {
            tabela[i % 3] += t[i];
        }
        return tabela;
    }
}