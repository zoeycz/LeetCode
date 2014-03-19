package minimum_path_sum;

/**
 * Mimimum Path Sum
 * http://oj.leetcode.com/problems/minimum-path-sum/
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * Solution: DP.
 * 
 * Complexity: Time - O(mn), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    if (m == 0) {
      return 0;
    }
    int n = grid[0].length;
    if (n == 0) {
      return 0;
    }
    int[][] optimal = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          optimal[i][j] = grid[i][j];
        } else if (i == 0) {
          optimal[i][j] = optimal[i][j - 1] + grid[i][j];
        } else if (j == 0) {
          optimal[i][j] = optimal[i - 1][j] + grid[i][j];
        } else {
          optimal[i][j] = Math.min(optimal[i - 1][j], optimal[i][j - 1])
              + grid[i][j];
        }
      }
    }
    return optimal[m - 1][n - 1];
  }
}
