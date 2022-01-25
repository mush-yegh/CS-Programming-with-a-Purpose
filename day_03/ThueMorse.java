public class ThueMorse {
  public static void main(String[] args) {
    final int n = Integer.parseInt(args[0]);

    String[] seq = new String[n];
    String[] reversed;
    seq[0] = "0";

    while (seq[seq.length - 1] == null) {
      reversed = new String[seq.length];

      for (int i = 0; i < seq.length; i++) {
        if (seq[i] == null) {
          break;
        }
        reversed[i] = seq[i].equals("0") ? "1" : "0";
      }

      for (int i = 0, j = 0; i < seq.length; i++) {
        if (seq[i] != null) {
          continue;
        }
        if (reversed[j] != null) {
          seq[i] = reversed[j];
          j++;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j != 0) {
          System.out.print("  ");
        }
        System.out.print(seq[i].equals(seq[j]) ? "+" : "-");
      }
      System.out.println();
    }
  }
}
