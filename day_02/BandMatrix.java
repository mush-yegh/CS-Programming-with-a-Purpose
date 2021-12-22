public class BandMatrix {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int width = Integer.parseInt(args[1]);

    for (int v = 0; v < n; v++) {
      for (int h = 0; h < n; h++) {
        char symbol = Math.abs(h - v) <= width ? '*' : '0';
        System.out.print(symbol + "  ");
      }
      System.out.println();
    }
  }
}
