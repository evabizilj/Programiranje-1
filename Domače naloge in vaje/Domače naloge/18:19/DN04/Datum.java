// 63160070
import java.util.*;

public class Datum {
  private int dan;
  private int mesec;
  private int leto;

  // Ustvari objekt, ki predstavlja datum s podanim dnevom, mesecem in letom.
  public Datum (int dan, int mesec, int leto) {
    this.dan = dan;
    this.mesec = mesec;
    this.leto = leto;
  }


  // Vrne dan datuma this (tj. zaporedno številko dneva v mesecu).
  public int vrniDan() {
    return this.dan;
  }

  // Vrne mesec datuma this (tj. zaporedno številko meseca v letu).
  public int vrniMesec () {
    return this.mesec;
  }

  // Vrne leto datuma this.
  public int vrniLeto() {
    return this.leto;
  }

  //Če je dan oziroma mesec enomestno število, naj bo zapisan z vodilno ničlo (npr. 06.09.2018 za šesti september 2018).
  public String toString() {
    if (dan < 10 && mesec < 10)
      return String.format("0" + dan + ".0" + mesec + "." + leto);
    if (mesec < 10)
      return String.format(dan + "." + "0" + mesec + "." + leto);
    if (dan < 10)
      return String.format("0" + dan + "." + mesec + "." + leto);
    return String.format("%2d.%2d.%2d", dan, mesec, leto);
  }

// Vrne true natanko v primeru, če objekt this predstavlja isti datum kot objekt datum.
  public boolean jeEnakKot(Datum datum) {
    return (this.dan == datum.dan && this.mesec == datum.mesec && this.leto == datum.leto);
  }
}
