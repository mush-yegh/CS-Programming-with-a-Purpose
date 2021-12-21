/**
 * Write a program that prints five uniform random numbers between 0 and 1, their average value, and
 * their minimum and maximum values. Use Math.random(), Math.min(), and Math.max().
 */
public class UniformRandomNumbers {
  public static void main(String[] args) {
    double r1 = Math.random();
    double r2 = Math.random();
    double r3 = Math.random();
    double r4 = Math.random();
    double r5 = Math.random();

    System.out.println(String.format("Five uniform random numbers: %f, %f, %f, %f, %f;", r1, r2, r3, r4, r5));
    System.out.println(String.format("The avarege value is: %.3f", (r1 + r2 + r3 + r4 + r5) / 5));
    System.out.println(
        String.format(
            "The max is: %f", Math.max(Math.max(Math.max(Math.max(r1, r2), r3), r4), r5)));
    System.out.println(
        String.format(
            "The min is: %f", Math.min(Math.min(Math.min(Math.min(r1, r2), r3), r4), r5)));
  }
}
