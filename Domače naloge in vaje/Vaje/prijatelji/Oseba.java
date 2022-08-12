public class Oseba {

    private String ip;   // ime in priimek
    private int starost;
    private PostniNaslov postniNaslov;
    private Oseba[] prijatelji;

    /*
     * Ustvari nov objekt razreda Oseba.  Tabele prijateljev ne nastavi.
     */
    public Oseba(String ip, int starost, PostniNaslov postniNaslov) {
        this.ip = ip;
        this.starost = starost;
        this.postniNaslov = postniNaslov;

        // zagotovi veljavnost tabele prijateljev, tudi če se metoda
        // nastaviPrijatelje nikoli ne pokliče
        this.prijatelji = new Oseba[0];
    }

    /*
     * Nastavi prijatelje osebe <this>.
     */
    public void nastaviPrijatelje(Oseba[] prijatelji) {
        this.prijatelji = prijatelji;
    }

    /*
     * Vrne predstavitev osebe <this> v obliki niza.
     */
    public String toString() {
        return String.format("%s (%d), %s",
						this.ip, this.starost, this.postniNaslov.toString());
    }

    /*
     * Vrne <true> natanko v primeru, če oseba <os> prebiva na istem naslovu
     * kot oseba <this>.
     */
    public boolean naIstemNaslovuKot(Oseba os) {
        return postniNaslov.jeEnakKot(os.postniNaslov);
    }

    /*
     * Vrne število prijateljev osebe <this>, ki živijo na istem naslovu kot
     * oseba <this>.
     */
    public int steviloPrijateljevNaIstemNaslovu() {
        int stPrijateljev = 0;
		for (int i = 0; i < prijatelji.length; i++){
			if(this.naIstemNaslovuKot(prijatelji[i])){
				stPrijateljev++;
			}
		}
		return stPrijateljev;
    }

    /*
     * Vrne najstarejšega prijatelja osebe <this> (prvega, če jih je več;
     * null, če jih ni).
     */
    public Oseba najstarejsiPrijatelj() {
        if (prijatelji == null || prijatelji.length == 0){
			return null;
		}
		int iNaj = 0;
		for (int i = 0; i < prijatelji.length; i++){
			if (prijatelji[i].starost > prijatelji[iNaj].starost){
				iNaj = i;
			}

		}
		return prijatelji[iNaj];
    }

    /*
     * Vrne <true> natanko v primeru, če je oseba <this> prijatelj osebe <os>.
     */
    public boolean jePrijateljOd(Oseba os) {
		for (int i = 0; i < os.prijatelji.length; i++) {
			if (os.prijatelji[i] == this)
				return true;
		}
  }

    /*
     * Vrne matriko prijateljstev za dano tabelo oseb (rezultat[i][j] == true
     * natanko tedaj, ko je oseba j prijatelj osebe i).
     */
    public static boolean[][] prijateljstva(Oseba[] osebe) {
		boolean[][] prijateljstva = new boolean[osebe.length][osebe.length];
		for (int i = 0; i < osebe.length; i++) {
			for (int j = 0; j < osebe.length; j++) {
				prijateljstva[i][j] = osebe[j].jePrijateljOd(osebe[i]);
			}
		}
        return prijateljstva;
    }
}
