public class WorldMap {

  public static void main(String[] args) {
    int width = StdIn.readInt();
    int height = StdIn.readInt();

    StdDraw.setCanvasSize(width, height);
    StdDraw.setXscale(0, width);
    StdDraw.setYscale(0, height);

    double[] x;
    double[] y;
    while (!StdIn.isEmpty()) {
      StdIn.readString();
      int verticesCount = StdIn.readInt();

      x = new double[verticesCount];
      y = new double[verticesCount];
      for (int i = 0; i < verticesCount; i++) {
        x[i] = StdIn.readDouble();
        y[i] = StdIn.readDouble();
      }
      StdDraw.polygon(x, y);
    }
    StdDraw.show();
  }
}
