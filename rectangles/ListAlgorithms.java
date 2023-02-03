package rectangles;

import java.util.*;

public class ListAlgorithms {

  /**
   * Returns a new list of rectangles by translating (moving) each rectangle according to the given
   * distance vector.
   *
   * @param rectangles The rectangles to be translated
   * @param vector The distance vector
   * @return The translated rectangles
   */
  public static List<Rectangle> translate(List<Rectangle> rectangles, Point vector) {
    List<Rectangle> newLs = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      Point newPoint = new Point(
              rectangle.getTopLeft().getX() + vector.getX(),
              rectangle.getTopLeft().getY() + vector.getY()
      );
      newLs.add(new Rectangle(newPoint, rectangle.getWidth(), rectangle.getHeight()));
    }
    return newLs;
  }

  /**
   * Returns a new list of rectangles by scaling each rectangle by a given amount.
   *
   * @param rectangles The rectangles to be scaled
   * @param factor A non-negative scale factor
   * @return The scaled rectangles
   */
  public static List<Rectangle> scale(List<Rectangle> rectangles, int factor) {

    List<Rectangle> newLs = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      newLs.add(new Rectangle(rectangle.getTopLeft(),
              rectangle.getWidth() * factor, rectangle.getHeight() * factor));
    }
    return newLs;
  }

  /** Returns a list containing, in order, the bottom-left point of each input rectangle. */
  public static List<Point> getBottomLeftPoints(List<Rectangle> rectangles) {

    List<Point> pointLs = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      pointLs.add(rectangle.getBottomLeft());
    }
    return pointLs;
  }

  /**
   * Returns a list containing all rectangles that intersect with the given rectangle.
   *
   * @param rectangles A list of rectangles to be checked for intersection
   * @param rectangle The rectangle against which intersection should be checked
   * @return All rectangles that do intersect with the given rectangle
   */
  public static List<Rectangle> getAllIntersecting(
      List<Rectangle> rectangles, Rectangle rectangle) {

    List<Rectangle> intersectLs = new ArrayList<>();
    for (Rectangle rectangle1 : rectangles) {
      if (rectangle.intersects(rectangle1)) {
        intersectLs.add(rectangle1);
      }
    }
    return intersectLs;
  }

  /**
   * Returns a list containing all rectangles with a bigger area than the given rectangle.
   *
   * @param rectangles A list of rectangles whose area is to be checked
   * @param rectangle The rectangle against which areas are to be compared
   * @return All rectangles that have a larger area than the given rectangle
   */
  public static List<Rectangle> getAllWithBiggerAreaThan(
      List<Rectangle> rectangles, Rectangle rectangle) {

    List<Rectangle> biggerLs = new ArrayList<>();
    for (Rectangle rectangle1 : rectangles) {
      if (rectangle1.area() > rectangle.area()) {
        biggerLs.add(rectangle1);
      }
    }
    return biggerLs;
  }

  /** Returns the largest area among the given rectangles. */
  public static int findLargestArea(List<Rectangle> rectangles) {
    int largestArea = 0;
    for (Rectangle rectangle : rectangles) {
      if (rectangle.area() >= largestArea) {
        largestArea = rectangle.area();
      }
    }
    return largestArea;
  }

  /** Returns the largest height among all the given rectangles. */
  public static int findMaxHeight(List<Rectangle> rectangles) {
    int maxHeight = 0;
    for (Rectangle rectangle : rectangles) {
      if (rectangle.getHeight() >= maxHeight) {
        maxHeight = rectangle.getHeight();
      }
    }
    return maxHeight;
  }

  /** Computes the sum of areas of all the given rectangles. */
  public static int getSumOfAreas(List<Rectangle> rectangles) {
    int sumArea = 0;
    for (Rectangle rectangle : rectangles) {
      sumArea += rectangle.area();
    }
    return sumArea;
  }

  /**
   * Computes the sum of areas of all rectangles that intersect with the given rectangle.
   *
   * @param rectangles The rectangles whose areas to be considered and summed
   * @param rectangle The rectangle with which intersection is to be checked
   * @return The sum of areas of all rectangles that do intersect with the given rectangle
   */
  public static int getSumOfAreasOfAllIntersecting(
      List<Rectangle> rectangles, Rectangle rectangle) {

    return getSumOfAreas(getAllIntersecting(rectangles, rectangle));
  }

  /** Returns collection that maps each rectangle to its computed area. */
  public static Map<Rectangle, Integer> getAreaMap(List<Rectangle> rectangles) {

    Map<Rectangle, Integer> areaMap = new HashMap<>();
    for (Rectangle rectangle : rectangles) {
      areaMap.put(rectangle, rectangle.area());
    }
    return areaMap;
  }
}
