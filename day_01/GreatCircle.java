public class GreatCircle {
  public static void main(String[] args) {
    double firstPointX = Math.toRadians(Double.parseDouble(args[0]));
    double firstPointY = Math.toRadians(Double.parseDouble(args[1]));
    double secondPointX = Math.toRadians(Double.parseDouble(args[2]));
    double secondPointY = Math.toRadians(Double.parseDouble(args[3]));

    double deltaX = secondPointX - firstPointX;
    double deltaY = secondPointY - firstPointY;

    double r = 6371.0;

    double distance =
        2
            * r
            * Math.asin(
                Math.sqrt(
                    Math.pow(Math.sin(deltaX / 2), 2)
                        + Math.cos(firstPointX)
                            * Math.cos(secondPointX)
                            * Math.pow(Math.sin(deltaY / 2), 2)));

    System.out.println(distance + " kilometers");
  }
}
