public class MaximumSquareSubmatrix {

  public static int size(int[][] a) {
    int len = a.length;
    int[][] sub = new int[len][len];
    int maxSize = 0;

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        maxSize = Math.max(a[i][j], maxSize);
        if (i == 0 || j == 0) {
          sub[i][j] = a[i][j];
        } else {
          if (a[i][j] == 1 && a[i - 1][j] == 1 && a[i - 1][j - 1] == 1 && a[i][j - 1] == 1) {
            sub[i][j] = Math.min(Math.min(sub[i - 1][j - 1], sub[i - 1][j]), sub[i][j - 1]) + 1;
            maxSize = Math.max(sub[i][j], maxSize);
          }
        }
      }
    }
    return maxSize;
  }

  public static void main(String[] args) {
    int n = StdIn.readInt();
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = StdIn.readInt();
      }
    }

    System.out.println(size(matrix));
  }
}
