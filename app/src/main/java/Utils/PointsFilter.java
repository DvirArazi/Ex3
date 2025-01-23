// Question 17.2
package Utils;

public class PointsFilter implements ShapeFilter {
  Point2D[] points;

  public PointsFilter(Point2D[] points) {
    this.points = points;
  }

  @Override
  public boolean filter(GeoShape s) {
    for (int i = 0; i < points.length; i++)
      if (!s.contains(points[i])) {
        return false;
      }

    return true;
  }
}
