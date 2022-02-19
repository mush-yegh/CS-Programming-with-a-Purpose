public class Minesweeper {
  public static void main(String[] args) {
    final int m = Integer.parseInt(args[0]);
    final int n = Integer.parseInt(args[1]);
    final int k = Integer.parseInt(args[2]);

    String[][] matrix = new String[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.toString(0);
      }
    }

    int minesCount = 0;
    while (minesCount < k) {
      int randomM = (int) (Math.random() * m);
      int randomN = (int) (Math.random() * n);
      if (!("*".equals(matrix[randomM][randomN]))) {
        matrix[randomM][randomN] = "*";
        minesCount++;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j].equals("*")) {
          // prev line
          if (i - 1 >= 0 && !(matrix[i - 1][j].equals("*"))) {
            matrix[i - 1][j] = String.valueOf(Integer.parseInt(matrix[i - 1][j]) + 1);
          }
          if (i - 1 >= 0 && j > 0 && !(matrix[i - 1][j - 1].equals("*"))) {
            matrix[i - 1][j - 1] = String.valueOf(Integer.parseInt(matrix[i - 1][j - 1]) + 1);
          }
          if (i - 1 >= 0 && j < n - 1 && !(matrix[i - 1][j + 1].equals("*"))) {
            matrix[i - 1][j + 1] = String.valueOf(Integer.parseInt(matrix[i - 1][j + 1]) + 1);
          }
          // current line
          if (j > 0 && !(matrix[i][j - 1].equals("*"))) {
            matrix[i][j - 1] = String.valueOf(Integer.parseInt(matrix[i][j - 1]) + 1);
          }
          if (j < n - 1 && !(matrix[i][j + 1].equals("*"))) {
            matrix[i][j + 1] = String.valueOf(Integer.parseInt(matrix[i][j + 1]) + 1);
          }
          // next line
          if (i + 1 < m && !(matrix[i + 1][j].equals("*"))) {
            matrix[i + 1][j] = String.valueOf(Integer.parseInt(matrix[i + 1][j]) + 1);
          }
          if (i + 1 < m && j > 0 && !(matrix[i + 1][j - 1].equals("*"))) {
            matrix[i + 1][j - 1] = String.valueOf(Integer.parseInt(matrix[i + 1][j - 1]) + 1);
          }
          if (i + 1 < m && j < n - 1 && !(matrix[i + 1][j + 1].equals("*"))) {
            matrix[i + 1][j + 1] = String.valueOf(Integer.parseInt(matrix[i + 1][j + 1]) + 1);
          }
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j]);
        if (j < n - 1) {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }
}
