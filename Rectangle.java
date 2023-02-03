package rectangles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Rectangle {
  private int x1;
  private int x2;
  private int y1;
  private int y2;

  public Rectangle(Point point, int width, int height) {
    this(point, new Point(point.getX() + width, point.getY() + height));
  }

  public Rectangle(int width, int height) {
    this(new Point(0, 0), new Point(width, height));
  }

  public Rectangle(Point point1, Point point2) {
    if (point1.getX() <= point2.getX()) {
      x1 = point1.getX();
      x2 = point2.getX();
    } else {
      x1 = point2.getX();
      x2 = point1.getX();
    }

    if (point1.getY() <= point2.getY()) {
      y1 = point1.getY();
      y2 = point2.getY();
    } else {
      y1 = point2.getY();
      y2 = point1.getY();
    }
  }

  public int getWidth() {
    return x2 - x1;
  }

  public int getHeight() {
    return y2 - y1;
  }

  public Rectangle setWidth(int newWidth) {
    if (newWidth >= 0) {
      x2 = x1 + newWidth;
    }
    return new Rectangle(new Point(x1, y1), new Point(x2, y2));
  }

  public Rectangle setHeight(int newHeight) {
    if (newHeight >= 0) {
      y2 = y1 + newHeight;
    }
    return new Rectangle(new Point(x1, y1), new Point(x2, y2));
  }

  public Point getTopLeft() {
    return new Point(x1, y1);
  }

  public Point getTopRight() {
    return new Point(x2, y1);
  }

  public Point getBottomLeft() {
    return new Point(x1, y2);
  }

  public Point getBottomRight() {
    return new Point(x2, y2);
  }

  public int area() {
    return (x2 - x1) * (y2 - y1);
  }

  public boolean intersects(Rectangle other) {
    boolean check = false;
    for (int x = other.x1; x <= other.x2;  x++) {
      for (int y = other.y1; y <= other.y2; y++) {
        if (isContain(new Point(x, y))) {
          check = true;
        }
      }
    }
    return check;
  }

  private boolean isContain(Point point) {

    boolean check = x1 <= point.getX() && point.getX() <= x2
            && y1 <= point.getY() && point.getY() <= y2;
    return check;
  }

  public Optional<Rectangle> intersection(Rectangle other) {

    Rectangle intersect = null;
    if (intersects(other)) {
      List<Point> pointLs = new ArrayList<>();
      for (int x = other.x1; x <= other.x2;  x++) {
        for (int y = other.y1; y <= other.y2; y++) {
          if (isContain(new Point(x, y))) {
            pointLs.add(new Point(x, y));
          }
        }
      }
      intersect = new Rectangle(pointLs.get(0), pointLs.get(pointLs.size() - 1));
    }
    return Optional.ofNullable(intersect);
  }

}