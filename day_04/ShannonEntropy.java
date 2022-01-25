public class ShannonEntropy {

  public static void main(String[] args) {
    final int m = Integer.parseInt(args[0]);
    final int[] frequencies = new int[m];
    final double[] proportions = new double[m];

    int num;
    int count = 0;
    while (!StdIn.isEmpty()) {
      num = StdIn.readInt();
      frequencies[num - 1] = frequencies[num - 1] + 1;
      count++;
    }

    for (int i = 0; i < frequencies.length; i++) {
      if (count != 0) {
        proportions[i] = (double) frequencies[i] / count;
      }
    }

    double entropy = 0.0;
    for (int i = 0; i < proportions.length; i++) {
      if (proportions[i] == 0.0) {
        continue;
      }
      entropy += -proportions[i] * (Math.log(proportions[i]) / Math.log(2));
    }
    System.out.println(String.format("%.4f", entropy));
  }
}
