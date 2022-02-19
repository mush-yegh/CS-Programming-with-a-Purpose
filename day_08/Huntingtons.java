public class Huntingtons {

  public static int maxRepeats(String dna) {
    int count = 0;
    int maxCount = 0;
    int len = dna.length();
    for (int i = 0; i < len; i++) {
      if ((i + 3) <= len && dna.substring(i, i + 3).equals("CAG")) {
        count++;
        i += 2;
      } else {
        count = 0;
      }
      maxCount = Math.max(count, maxCount);
    }
    return maxCount;
  }

  public static String removeWhitespace(String s) {
    String newStr = s.replace(" ", "");
    newStr = newStr.replace("\t", "");
    newStr = newStr.replace("\n", "");
    return newStr;
  }

  public static String diagnose(int maxRepeats) {
    if (maxRepeats <= 9 || maxRepeats >= 181) {
      return "not human";
    } else if (maxRepeats <= 35) {
      return "normal";
    } else if (maxRepeats <= 39) {
      return "high risk";
    } else {
      return "Huntington's";
    }
  }

  public static void main(String[] args) {
    String filename = args[0];
    In in = new In(filename);
    String dna = in.readAll();
    dna = removeWhitespace(dna);
    int repeats = maxRepeats(dna);
    StdOut.println(String.format("max repeats = %s", repeats));
    StdOut.println(diagnose(repeats));
  }
}
