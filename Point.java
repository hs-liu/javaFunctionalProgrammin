package rectangles;

public final class Point {
  private int x;
  private int y;

  //constructor
  public Point() {
    this(0, 0);
  }

  public Point(int x) {
    this(x, 0);
  }

  public Point(int x, int y) {
    if (x >= 0 && y >= 0) {
      this.x = x;
      this.y = y;
    }
  }

  //public methods
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Point setX(int newX) {
    if (newX >= 0) {
      x = newX;
    }
    return new Point(x, y);
  }

  public Point setY(int newY) {
    if (newY >= 0) {
      y = newY;
    }
    return new Point(x, y);
  }

  public Boolean isLeftOf(Point other) {
    return other.x > x;
  }

  public Boolean isRightOf(Point other) {
    return other.x < x;
  }

  public Boolean isAbove(Point other) {
    return other.y > y;
  }

  public Boolean isBelow(Point other) {
    return other.y < y;
  }

  public Point add(Point vector) {
    return new Point(vector.x + x, vector.y + y);
  }
}
