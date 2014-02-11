package set_matrix_zeroes;

/**
 * Set Matrix Zeroes
 * http://oj.leetcode.com/problems/set-matrix-zeroes/
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * Solution: In-place solution, take line 0 and column 0 as indicator of 0
 * position in matrix.
 * Before they are used as indicators, record the original status of themselves.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    if (m == 0 || n == 0) {
      return;
    }
    boolean resetColumn0 = false;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        resetColumn0 = true;
      }
    }
    boolean resetLine0 = false;
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == 0) {
        resetLine0 = true;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (resetColumn0) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }

    if (resetLine0) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }
  }
}