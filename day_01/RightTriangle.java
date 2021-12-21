public class RightTriangle {
  public static void main(String[] args) {
    int sideA = Integer.parseInt(args[0]);
    int sideB = Integer.parseInt(args[1]);
    int sideC = Integer.parseInt(args[2]);

    boolean isEachArgPositive = sideA > 0 && sideB > 0 && sideC > 0;

    double sqrtOfMaxInt = Math.sqrt(Integer.MAX_VALUE);
    boolean isEachArgInTheValidRange =
        isEachArgPositive && sideA < sqrtOfMaxInt && sideB < sqrtOfMaxInt && sideC < sqrtOfMaxInt;

    boolean isRightTriangle =
        isEachArgInTheValidRange
            && (sideA * sideA + sideB * sideB == sideC * sideC
                || sideA * sideA + sideC * sideC == sideB * sideB
                || sideC * sideC + sideB * sideB == sideA * sideA);

    System.out.println(isRightTriangle);
  }
}

