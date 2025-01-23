
// Question 19

import Utils.Circle2D;
import Utils.GeoShape;
import Utils.Point2D;

public class Pizza implements GeoShape {
  Circle2D circle;
  double degreeStart;
  double degreeEnd;

  public Pizza(Circle2D circle, double degreeStart, double degreeEnd) {
    this.circle = circle;
    this.degreeStart = degreeStart;
    this.degreeEnd = degreeEnd;
  }

  @Override
  public boolean contains(Point2D ot) {
    double angle = Math.atan2(
        ot.y() - circle.getCenter().y(),
        ot.x() - circle.getCenter().x());
    return degreeStart < angle && angle < degreeEnd;
  }

  @Override
  public double area() {
    return circle.area() * (degreeEnd - degreeStart) / 360;
  }

  @Override
  public double perimeter() {
    return 2 * circle.getRad() +
        circle.perimeter() * (degreeEnd - degreeStart) / 360;
  }

  @Override
  public GeoShape copy() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Point2D innerPoint() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void move(Point2D vec) {
    // TODO Auto-generated method stub

  }
}
