public class RevesPuzzle {


  private static void hanoiTreePoles(int n, int k, String from, String temp, String to) {
    if (n == k) {
      return;
    }
    hanoiTreePoles(n - 1, k, from, to, temp);
    System.out.println("Move disc " + n + " from " + from + " to " + to);
    hanoiTreePoles(n - 1, k, temp, from, to);
  }

  private static void hanoiFourPoles(int n, String from, String tmp1, String tmp2, String to) {
    if (n == 0) {
      return;
    }
    int newN = (int) (Math.round(n + 1 - Math.sqrt(2 * n + 1)));
    hanoiFourPoles(newN, from, to, tmp2, tmp1);
    hanoiTreePoles(n, newN, from, tmp2, to);
    hanoiFourPoles(newN, tmp1, from, tmp2, to);
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    hanoiFourPoles(n, "A", "B", "C", "D");
  }
}
