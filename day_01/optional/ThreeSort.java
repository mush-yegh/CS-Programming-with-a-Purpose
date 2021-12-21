/**
 * Write a program that takes three integer command-line arguments and prints them in ascending
 * order. Use Math.min() and Math.max().
 */
public class ThreeSort {
  public static void main(String[] args) {
    int num1 = Integer.parseInt(args[0]);
    int num2 = Integer.parseInt(args[1]);
    int num3 = Integer.parseInt(args[2]);

    int min = Math.min(Math.min(num1, num2), num3);
    int max = Math.max(Math.max(num1, num2), num3);
    System.out.println(min + ", " + ((num1 + num2 + num3) - (min + max)) + ", " + max);
  }
}
