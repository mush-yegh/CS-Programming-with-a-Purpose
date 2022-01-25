public class Checkerboard {

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);

    StdDraw.setScale(0, n);
    boolean isBlue = true;

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        StdDraw.setPenColor(isBlue ? StdDraw.BLUE : StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
        if (!(x == n - 1 && n % 2 == 0)) {
          isBlue = !isBlue;
        }
      }
    }
    StdDraw.show();
  }
}
