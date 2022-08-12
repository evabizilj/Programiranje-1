// 63160070
import java.util.*;

public class Bankomat {
  private int N5 = 0;
  private int N2 = 0;
  private int N1 = 0;

  // Ustvari objekt, ki predstavlja bankomat na začetku delovanja. Bankomat je tedaj prazen.
  public Bankomat() {
  }

  // Vrne trenutno število bankovcev za 5 dinarjev v bankomatu this.
  public int vrniN5() {
    return this.N5;
  }

  // Vrne trenutno število bankovcev za 2 dinarja v bankomatu this.
  public int vrniN2() {
    return this.N2;
  }

  // Vrne trenutno število bankovcev za 1 dinar v bankomatu this.
  public int vrniN1() {
    return this.N1;
  }

// Posodobi stanje bankomata this, potem ko tehnik vanj vstavi k5 bankovcev po 5 dinarjev, k2 bankovcev za 2 dinarja in k1 bankovcev za 1 dinar.

  public void nalozi(int k5, int k2, int k1) {
    this.N5 += k5;
    this.N2 += k2;
    this.N1 += k1;
  }

// Izpise niz oblike n5␣|␣n2␣|␣n1, kjer n5, n2 in n1 predstavljajo stevilo bankovcev po 5 dinarjev, 2 dinarja oziroma 1 dinar,
// ki jih bankomat this trenutno vsebuje. Izpis naj se zakljuci s skokom v naslednjo vrstico. Na primer, ce bankomat vsebuje 7 bankovcev po 5 dinarjev,
//11 bankovcev po 2 dinarja in 6 bankovcev po 1 dinar, naj metoda izpiše
// 7 | 11 | 6

  public void izpisi() {
    System.out.printf("%d | %d | %d\n", vrniN5(), vrniN2(), vrniN1());
  }

// Vrne trenutno kolicino denarja v bankomatu this.
  public int kolicinaDenarja() {
    return vrniN5() * 5 + vrniN2() * 2 + vrniN1();
  }

// Simulira dogodek, ko stranka poskusa na datum datum iz bankomata this dvigniti dvig dinarjev. Ce bankomat zneska ne
// more izplacati, naj se njegovo stanje ne spremeni, metoda pa naj vrne false. V nasprotnem primeru naj pri
// izplacevanju zelenega zneska bankomat izda karseda veliko 5-dinarskih bankovcev, morebitni pre- ostanek pa naj
// izplaca s karseda velikim številom 2-dinarskih bankovcev.

// Datumi si v zaporednih klicih metode dvigni sledijo v kronoloskem vrstnem redu. Nikoli se torej ne zgodi, da bi datum v
// nekem klicu metode dvigni nastopil kasneje kot datum v nekem poznejsem klicu metode dvigni.
// V primerih J6 in S26–S30 velja dvig < 5. V vseh primerih velja dvig > 0.

  int vrednostMaksimumDviga = 0;
  Datum danasnjiDatum = null;
  int danasnjaVsota = 0;
  Datum datumNajvecjeVsote = null;
  int najvecjaVsota = 0;
  public boolean dvigni(int dvig, Datum datum) {
    int vsota = 0;

    int izplacaj5 = Math.min(dvig/5, this.N5);
    vsota += izplacaj5 * 5;

    int izplacaj2 = Math.min((dvig - vsota)/2, this.N2);
    vsota += izplacaj2 * 2;

    int izplacaj1 = Math.min(dvig - vsota, this.N1);
    vsota += izplacaj1 * 1;

    int ostanek = dvig - vsota;
    if (ostanek == 1 && izplacaj5 > 0 && this.N2 >= 3) { // bankomat dobi 5, vsota = -5 * 3 * 2
      izplacaj5 -= 1;
      izplacaj2 += 3;
      vsota += 1;
    }

    if (dvig != vsota) { // ne moremo izplacati zneska
      return false;
    }

    this.N5 -= izplacaj5;
    this.N2 -= izplacaj2;
    this.N1 -= izplacaj1;

    if (dvig > vrednostMaksimumDviga) {
      vrednostMaksimumDviga = dvig;
    //  datumMaksimumDviga = datum;
    }

    if (danasnjiDatum == null || !danasnjiDatum.jeEnakKot(datum)) { // zacel se je nov dan
      danasnjaVsota = 0;
      danasnjiDatum = datum;
    }

    danasnjaVsota += dvig;
    if (danasnjaVsota > najvecjaVsota) {
      najvecjaVsota = danasnjaVsota;
      datumNajvecjeVsote = danasnjiDatum;
    }

//  maksimumDvig = Math.max(maksimumDvig, dvig);
    return true;
  }

// Vrne najvecjo kolicino denarja, ki je bila iz bankomata this dvignjena v enem samem uspesnem dvigu. Ce ni bilo še nobenega uspesnega dviga, naj metoda vrne 0.
// Najvecji enkratni uspesni dvig; ukvarjamo se samo s posamicnimi dvigi, pri katerih je bankomat dejansko lahko izplacal zahtevani znesek.
  public int najDvig() {
    return vrednostMaksimumDviga;
  }

// Vrne datum, ko je bilo iz bankomata this dvignjenega najvec denarja, pri cemer se vnovic upostevajo samo uspesni dvigi. Ce je takih datumov vec, naj metoda vrne prvega (torej najzgodnejsega) med njimi. Ce ni bilo se nobenega uspesnega dviga, naj metoda vrne null.
// Sprašuje po dnevu, ko je bankomat izplacal največ denarja.
/*
Tesni primer 9
15. marca 2018 je izplacal 22 dinarjev,
20. januarja 2019 je izplacal 18 dinarjev (13 + 5, dvig 17 dinarjev ni bil uspešen).
3. in 4. februarja je izplačal 23 dinarjev.
*/
  public Datum najDatum() {
    return datumNajvecjeVsote;
  }
}
