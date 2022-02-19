public class Inversions {

  public static long count(int[] a) {
    long count = 0;
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = i; j < a.length; j++) {
        if (a[i] > a[j]) {
          count++;
        }
      }
    }

    return count;
  }

  public static int[] generate(int n, long k) {
    int[] arr = new int[n];
    long inversionCount = k;
    int firstIndex = 0;
    int lastIndex = n - 1;

    for (int i = n - 1; i > 0; i--) {
      if (inversionCount >= i) {
        arr[firstIndex++] = i;
        inversionCount = inversionCount - i;
      } else {
        arr[lastIndex--] = i;
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    long k = Long.parseLong(args[1]);

    int[] a = generate(n, k);
    for (int i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
  }
}
