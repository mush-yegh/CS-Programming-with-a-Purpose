public class RandomWalkers {
  public static void main(String[] args) {
    int r = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);

    double total = 0;
    for (int i = 0; i < trials; i++) {
      int steps = 0;
      int x = 0;
      int y = 0;
      while (r > (Math.abs(x) + Math.abs(y))) {
        double random = Math.random();
        if (random < 0.25) {
          x++;
        } else if (random < 0.5) {
          y++;
        } else if (random < 0.75) {
          x--;
        } else {
          y--;
        }
        steps++;
      }
      total += steps;
    }

    System.out.println("average number of steps = " + total / trials);
  }
}
