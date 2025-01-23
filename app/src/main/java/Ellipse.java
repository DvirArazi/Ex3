
// Quesion 14
import Utils.Point2D;

public class Ellipse {
  private Point2D p;
  private Point2D q;
  private double n;

  public Ellipse(double xp, double yp, double xq, double yq, double n) {
    p = new Point2D(xp, yp);
    q = new Point2D(xq, yq);
    this.n = n;
  }

  public Ellipse(Ellipse other) {
    p = new Point2D(other.p);
    q = new Point2D(other.q);
    n = other.n;
  }

  public int where(Point2D r) {
    double len = distance(p, r) + distance(q, r);

    return len > 0 ? 1 : len < 0 ? -1 : 0;
  }

  static double distance(Point2D a, Point2D b) {
    double xDiff = a.x() - b.x();
    double yDiff = a.y() - b.y();
    return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
  }

  public boolean equals(Ellipse e) {
    return p.equals(e.p) && q.equals(e.q) && n == e.n;
  }
}
