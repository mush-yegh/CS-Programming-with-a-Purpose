public class DiscreteDistribution {

  public static void main(String[] args) {
    final int m = Integer.parseInt(args[0]);

    int[] cumulativeSum = new int[args.length];
    cumulativeSum[0] = 0;

    for (int i = 1; i < args.length; i++) {
      int sum = 0;
      for (int j = 1; j <= i; j++) {
        sum = sum + Integer.parseInt(args[j]);
      }
      cumulativeSum[i] = sum;
    }

    int r;
    for (int i = 0; i < m; i++) {
      r = (int) (Math.random() * cumulativeSum[cumulativeSum.length - 1]);
      if (i > 0) {
        System.out.print(" ");
      }
      if (i != 0 && i % 25 == 0) {
        System.out.println();
      }

      for (int j = 0; j < cumulativeSum.length - 1; j++) {
        if (r >= cumulativeSum[j] && r < cumulativeSum[j + 1]) {
          System.out.print((j + 1));
        }
      }
    }
  }
}
