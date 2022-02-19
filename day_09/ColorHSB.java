public class ColorHSB {

  private final int h;
  private final int s;
  private final int b;

  public ColorHSB(int h, int s, int b) {
    if ((h < 0 || h >= 360) || (s < 0 || s > 100) || (b < 0 || b > 100)) {
      throw new IllegalArgumentException("Invalid argument(s) received");
    }
    this.h = h;
    this.s = s;
    this.b = b;
  }

  public boolean isGrayscale() {
    return this.s == 0 || this.b == 0;
  }

  public int distanceSquaredTo(ColorHSB that) {
    if (that == null) {
      throw new IllegalArgumentException();
    }

    return Math.min(
            (int) (Math.pow(this.h - that.h, 2)),
            (int) Math.pow(360 - Math.abs(this.h - that.h), 2))
        + (int) Math.pow(this.s - that.s, 2)
        + (int) Math.pow(this.b - that.b, 2);
  }

  public String toString() {
    return String.format("(%s, %s, %s)", this.h, this.s, this.b);
  }

  public static void main(String[] args) {
    final int hue = Integer.parseInt(args[0]);
    final int saturation = Integer.parseInt(args[1]);
    final int brightness = Integer.parseInt(args[2]);

    ColorHSB hsb = new ColorHSB(hue, saturation, brightness);

    String nextName = StdIn.readString();
    int nextH = StdIn.readInt();
    int nextS = StdIn.readInt();
    int nextB = StdIn.readInt();
    ColorHSB nextHSB = new ColorHSB(nextH, nextS, nextB);
    ColorHSB found = new ColorHSB(nextH, nextS, nextB);
    String foundName = nextName;

    int minDistance = hsb.distanceSquaredTo(nextHSB);
    int distance;

    while (StdIn.hasNextLine()) {
      nextName = StdIn.readString();
      nextHSB = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
      distance = hsb.distanceSquaredTo(nextHSB);

      if (distance < minDistance) {
        minDistance = distance;
        found = nextHSB;
        foundName = nextName;
      }
    }
    StdOut.println(String.format("%s %s", foundName, found));
  }
}

