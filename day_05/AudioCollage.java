public class AudioCollage {

  public static double[] amplify(double[] a, double alpha) {
    double[] rescaled = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      rescaled[i] = a[i] * alpha;
    }
    return rescaled;
  }

  public static double[] reverse(double[] a) {
    double[] reversed = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      reversed[i] = a[(a.length - 1) - i];
    }
    return reversed;
  }

  public static double[] merge(double[] a, double[] b) {
    double[] concatenated = new double[a.length + b.length];
    for (int i = 0; i < a.length; i++) {
      concatenated[i] = a[i];
    }
    for (int i = 0; i < b.length; i++) {
      concatenated[a.length + i] = b[i];
    }
    return concatenated;
  }

  public static double[] mix(double[] a, double[] b) {
    int length = a.length > b.length ? a.length : b.length;
    double[] summed = new double[length];
    double itemOfA, itemOfB;
    for (int i = 0; i < summed.length; i++) {
      itemOfA = i < a.length ? a[i] : 0.0;
      itemOfB = i < b.length ? b[i] : 0.0;
      summed[i] = itemOfA + itemOfB;
    }
    return summed;
  }

  public static double[] changeSpeed(double[] a, double alpha) {
    int length = (int) (a.length / alpha);
    double[] changed = new double[length];
    for (int i = 0; i < changed.length; i++) {
      changed[i] = a[(int) (i * alpha)];
    }
    return changed;
  }

  private static double[] fitDuration(double[] a, int minDuration, int maxDuration) {
    if (a.length < minDuration) {
      double[] result = new double[minDuration + 1];
      int aIndex = 0;
      for (int i = 0; i < result.length; i++) {
        result[i] = a[aIndex];
        aIndex++;
        if (aIndex == (a.length - 1)) {
          aIndex = 0;
        }
      }
      return result;
    }
    if (a.length > maxDuration) {
      double[] result = new double[maxDuration - 1];
      for (int i = 0; i < result.length; i++) {
        result[i] = a[i];
      }
      return result;
    }
    return a;
  }

  private static double[] normalize(double[] a) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] > 1) {
        a[i] = 1;
      }
      if (a[i] < -1) {
        a[i] = -1;
      }
    }
    return a;
  }

  public static void main(String[] args) {
    double[] dialup = StdAudio.read("dialup.wav");
    double[] piano = StdAudio.read("piano.wav");
    double[] beatbox = StdAudio.read("beatbox.wav");
    double[] buzzer = StdAudio.read("buzzer.wav");
    double[] chimes = StdAudio.read("chimes.wav");
    int minDuration = 441_000;
    int maxDuration = 2_646_000;

    double[] amlifiedPianoo = amplify(piano, 0.9);
    StdAudio.play(normalize(fitDuration(amlifiedPianoo, minDuration, maxDuration)));

    double[] reversedChimes = reverse(chimes);
    StdAudio.play(normalize(fitDuration(reversedChimes, minDuration, maxDuration)));

    double[] pianoMergedWithDialup = merge(piano, dialup);
    StdAudio.play(normalize(fitDuration(pianoMergedWithDialup, minDuration, maxDuration)));

    double[] buzzerMixedWithBeatbox = mix(buzzer, beatbox);
    StdAudio.play(normalize(fitDuration(buzzerMixedWithBeatbox, minDuration, maxDuration)));

    double[] pianoRemixed = changeSpeed(piano, 1.2);
    StdAudio.play(normalize(fitDuration(pianoRemixed, minDuration, maxDuration)));
  }
}
