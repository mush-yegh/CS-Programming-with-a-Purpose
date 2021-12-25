public class Divisors {

  public static int gcd(int a, int b) {
    if (a == 0 && b == 0) {
      return 0;
    }
    int x = Math.abs(a);
    int y = Math.abs(b);
    int tmp;

    while (y != 0) {
      tmp = x;
      x = y;
      y = tmp % y;
    }
    return x;
  }

  public static int lcm(int a, int b) {
    if (a == 0 || b == 0) {
      return 0;
    }
    int x = Math.abs(a);
    int y = Math.abs(b);
    return (x / gcd(a, b)) * y;
  }

  public static boolean areRelativelyPrime(int a, int b) {
    return gcd(a, b) == 1;
  }

  public static int totient(int n) {
    int countOfIntegers = 0;

    for (int i = 1; i <= n; i++) {
      if (areRelativelyPrime(i, n)) {
        countOfIntegers++;
      }
    }
    return countOfIntegers;
  }

  public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
    System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
    System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
    System.out.println("totient(" + a + ") = " + totient(a));
    System.out.println("totient(" + b + ") = " + totient(b));
  }
}
