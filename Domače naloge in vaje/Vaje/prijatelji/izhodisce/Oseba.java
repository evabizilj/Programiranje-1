
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
        return String.format("%s (%d), %s",this.pn, this.starost, this.postniNaslov.toString());
    }

    
    /*
     * Vrne <true> natanko v primeru, če oseba <os> prebiva na istem naslovu
     * kot oseba <this>.
     */
    
    public boolean naIstemNaslovuKot(Oseba os) {
        return this.postniNaslov.jeEnakKot(os.postniNaslov);
    }

            
    /*
     * Vrne število prijateljev osebe <this>, ki živijo na istem naslovu kot
     * oseba <this>.
     */
    public int steviloPrijateljevNaIstemNaslovu() {
        int stevec = 0;
        for (int i = 0; i < this.prijatelji.length; i++) {
            if (this.prijatelji[i].naIstemNaslovuKot(this)) {
                stevec++;
            }
        }
        return stevec;
            
        
    }

            
    /*
     * Vrne najstarejšega prijatelja osebe <this> (prvega, če jih je več;
     * null, če jih ni).
     */
    public Oseba najstarejsiPrijatelj() {
        if (this.prijatelji.length == 0) {
            return null;
        }
        int iNajP = 0; // indeks do slej najstarejšega prijatelja
        for (int i = 1; i < this.prijatelji.length; i++) {
            if (this.prijatelji[i].starost > this.prijatelji[iNajP].starost)
                iNajP = i;
        }
        
    }
    return this.prijatelji[iNajP];
}

    /*
     * Vrne <true> natanko v primeru, če je oseba <this> prijatelj osebe <os>.
     */
    public boolean jePrijateljOd(Oseba os) {
        for(int i = 0; i < os.prijatelji.length; i++) {
            if(os.prijatelji[i] == this)
                return true;
        }
    }
    return false;
}

    /*
     * Vrne matriko prijateljstev za dano tabelo oseb (rezultat[i][j] == true
     * natanko tedaj, ko je oseba j prijatelj osebe i).
     */
        // metoda je statična!!!
    public static boolean[][] prijateljstva(Oseba[] osebe) {
        int stOseb = osebe.length;
        boolean[][] rezulat = new boolean[stOseb][stOseb];
        for (int i = 0; i < stOseb; i++) {
            for (int j = 0; j < stOseb; j++) {
        rezultat[i][j] = osebe[j].jePrijateljOd(osebe[i]);
        }
    }
    return rezultat
}



