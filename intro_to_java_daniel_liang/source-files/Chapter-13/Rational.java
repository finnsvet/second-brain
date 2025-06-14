public class Rational extends Number implements Comparable<Rational> {

  private long numerator;
  private long denominator;

  public Rational() {
    this(0, 1);
  }

  public Rational(long numerator, long denominator) {
    long gcd = gcd(numerator, denominator);
    this.numerator = ((denominator > 0 ? 1 : -1) * numerator) / gcd;
    this.denominator = Math.abs(denominator) / gcd;
  }

  private static long gcd(long n, long d) {
    long n1 = Math.abs(n);
    long n2 = Math.abs(d);
    long gcd = 1;

    for (int i = 1; i <= n1 && i <= n2; ++i) {
      if (n1 % i == 0 && n2 % i == 0) gcd = i;
    }
    return gcd;
  }

  public long getNumerator() {
    return numerator;
  }

  public long getDenominator() {
    return denominator;
  }

  public Rational add(Rational second) {
    long n =
      numerator * second.getDenominator() + denominator * second.getNumerator();
    long d = denominator * second.getDenominator();
    return new Rational(n, d);
  }

  public Rational subtract(Rational second) {
    long n =
      numerator * second.getDenominator() - denominator * second.getNumerator();
    long d = denominator * second.getDenominator();
    return new Rational(n, d);
  }

  public Rational multiply(Rational second) {
    long n = numerator * second.getNumerator();
    long d = denominator * second.getDenominator();
    return new Rational(n, d);
  }

  public Rational divide(Rational second) {
    long n = numerator * second.getDenominator();
    long d = denominator * second.getNumerator();
    return new Rational(n, d);
  }

  @Override
  public String toString() {
    if (denominator == 1) return numerator + "";
    else return numerator + "/" + denominator;
  }

  @Override
  public boolean equals(Object other) {
    if ((this.subtract((Rational) other)).getNumerator() == 0) return true;
    else return false;
  }

  @Override
  public double doubleValue() {
    return (numerator * 1.0) / denominator;
  }

  @Override
  public int intValue() {
    return (int) doubleValue();
  }

  @Override
  public float floatValue() {
    return (float) doubleValue();
  }

  @Override
  public long longValue() {
    return (long) doubleValue();
  }

  @Override
  public int compareTo(Rational o) {
    if (this.subtract(o).getNumerator() > 0) return 1;
    else if (this.subtract(o).getNumerator() < 0) return -1;
    else return 0;
  }
}
