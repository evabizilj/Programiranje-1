
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

public class Prva {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    //=========================================================================
    // V vseh testnih primerih velja t.length >= 2, t.length <= 1000 in d >= 1.
    //
    // V primerih J1--J2 in S1--S10 tabela t vsebuje natanko en element z
    // iskano lastnostjo.
    //=========================================================================

    public static int zadnjiDeljiviPar(int[] t, int d) {
		int index = -1;
		for (int i = 1; i < t.length; i++) {
			if (t[i - 1] % d == 0 && t[i] % d == 0)
				index = i;
		}
		return index;
    }

    //=========================================================================
    // V vseh testnih primerih velja n >= 1.
    //
    // V primerih J6--J7 in S26--S35 "stevilo n vsebuje natanko eno ni"clo.
    //=========================================================================

    public static long odstraniNicle(long n) {
		long stevilo = n;
		long stevka = 0;
		long stevilo2 = 0;
		long rezultat = 0;

		while (stevilo > 0) {
			if (stevilo % 10 != 0) {
				stevka = stevilo % 10;
				stevilo2 = stevilo2 * 10 + stevka;
			}
			stevilo /= 10;
		}

		while (stevilo2 > 0) {
			stevka = stevilo2 % 10;
			rezultat = rezultat * 10 + stevka;
			stevilo2 /= 10;
		}
		return rezultat;
	}
}
