// Question 17.1


import Utils.GeoShape;
import Utils.ShapeFilter;

public class AreaFilter implements ShapeFilter {
    GeoShape shape;

    public AreaFilter(GeoShape shape) {
      this.shape = shape;
    }

    @Override
    public boolean filter(GeoShape s) {
      return s.area() > shape.area();
    }
}
