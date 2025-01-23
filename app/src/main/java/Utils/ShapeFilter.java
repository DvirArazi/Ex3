package Utils;

public interface ShapeFilter {
  public boolean filter(GeoShape s); // returns true iff s passes this Filter.
}
