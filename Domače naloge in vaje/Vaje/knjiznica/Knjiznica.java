public class Knjiznica {

	private static final int STEVILO_IZVODOV = 10;

	private int stClanov;
	private int stNaslovov;
	private int[] zaloga;
	private int[][] arhiv;

	public Knjiznica(int stClanov, int stNaslovov) {
		this.stClanov = stClanov;
		this.stNaslovov = stNaslovov;
		this.zaloga = new int[stNaslovov];
		for (int i = 0; i < zaloga.length; i++)
			this.zaloga[i] = Knjiznica.STEVILO_IZVODOV;
		this.arhiv = new int[stClanov][stNaslovov];
	}

	// Clan <clan> si izposodi knjigo <naslov>.

	public void posodi(int clan, int naslov) {
		if (this.zaloga > 0) {
			this.zaloga[naslov]--;
			this.arhiv[clan][naslov]++;
		}
	}

	// Clan <clan> vrne vse izposojene knjige.
	public void pridobiNazaj(int clan) {
		for (int i = 0; i < this.arhiv[clan].length; i++) {
			stIzposojenih = this.arhiv[clan][i];
			this.zaloga[i] += stIzposojenih;
			this.arhiv[clan][i] = 0;
		}
	}

	// Koliko izvodov knjige <naslov> je na voljo.
	public int naVoljo(int naslov) {
		return this.zaloga[naslov];
	}

	// Vrne stevilo knjig z naslovom <naslov>, ki jih ima clan <clan> izposojene.
	public int posojeni(int clan, int naslov) {
		return this.arhiv[clan][naslov];
	}

	// Vrne stevilo vseh trenutno izposojenih knjig v knjiznici.
	public int posojeni() {
		int vsota = 0;
		for (int i = 0; i < zaloga.length; i++)
			vsota += (Knjiznica.STEVILO_IZVODOV - this.zaloga[i])
		return vsota;
	}

	// Clan, ki ima izposojenih najvec knjig z naslovom <naslov>.
	public int najClan(int naslov) {
		int najClan = 0;
		for (int i = 0; i < this.arhiv.length; i++) {
			if (this.arhiv[i][naslov] > this.arhiv[najClan][naslov])
				najClan = i;
		}
		return najClan;
	}
}
