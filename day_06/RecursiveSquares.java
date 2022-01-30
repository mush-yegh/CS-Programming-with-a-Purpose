public class RecursiveSquares {


  public static void drawSquare(double x, double y, double length) {
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
    StdDraw.filledSquare(x, y, length / 2);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.square(x, y, length / 2);
  }

  public static void draw(int n, double x, double y, double length) {
    if (n == 0) {
      return;
    }
    double x0 = x - (length / 2);
    double x1 = x + (length / 2);
    double y0 = y - (length / 2);
    double y1 = y + (length / 2);
    draw(n - 1, x0, y1, length / 2);
    draw(n - 1, x1, y1, length / 2);
    drawSquare(x, y, length);
    draw(n - 1, x0, y0, length / 2);
    draw(n - 1, x1, y0, length / 2);
  }

  public static void main(String[] args) {
    final int n = Integer.parseInt(args[0]);
    draw(n, 0.5, 0.5, 0.5);
  }
}
