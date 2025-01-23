
// Question 15
import Utils.Parabula;

public class ParabulaClass implements Parabula {
  private double a;
  private double b;
  private double c;

  public ParabulaClass(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public double f(double x) {
    return a * x * x + b * x + c;
  }

  @Override
  public Parabula add(Parabula p) {
    double[] params = p.get();
    double pa = params[0];
    double pb = params[1];
    double pc = params[2];
    return new ParabulaClass(a + pa, b + pb, c + pc);
  }

  @Override
  public double[] get() {
    return new double[] { a, b, c };
  }

  @Override
  public double extream(Parabula p) {
    if (a == 0)
      throw new ArithmeticException();

    return -b / (2 * a);
  }
}
