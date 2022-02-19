public class Ramanujan {

  public static boolean isRamanujan(long n) {
    int successCount = 0;
    long i = 1, num1 = 1, num2;
    long firstFound = 0;

    while (num1 <= n - num1) {
      if (successCount == 2) {
        break;
      }
      num1 = i * i * i;
      num2 = (long) Math.cbrt(n - num1);
      if (num1 + num2 * num2 * num2 == n) {
        if (firstFound == 0) {
          firstFound = i;
        }
        if (firstFound != num2) {
          successCount++;
        }
      }
      i++;
    }
    return successCount == 2;
  }

  public static void main(String[] args) {
    long n = Long.parseLong(args[0]);
    System.out.println(isRamanujan(n));
  }
}
