public class Fibonacci {

  private int predprejsnji;
  private int prejsnji;

  public Fibonacci(int prvi, int drugi) {
    this.predprejsnji = prvi;
    this.prejsnji = drugi;
  }

  public int naslednji() {
    int trenutni = this.predprejsnji + this.prejsnji;
    this.predprejsnji = this.prejsnji;
    this.prejsnji = trenutni;
    return trenutni;
  }
}
   