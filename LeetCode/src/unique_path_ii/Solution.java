package unique_path_ii;

/**
 * Unique Path II
 * http://oj.leetcode.com/problems/unique-paths-ii/
 * 
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Solution: Take current obstacle into consideration.
 * Set corresponding grid to 0 if there's an obstacle.
 * 
 * Complexity: Time - O(mn), Space - O(mn)
 * 
 * Optimization: Space can be improved to O(m).
 * 
 * @author CAI Zhe
 */

public class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    if (m < 1) {
      return 0;
    }
    int n = obstacleGrid[0].length;
    if (obstacleGrid[0][0] == 1)
      return 0;
    int[][] result = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          result[i][j] = 1;
        } else if (i == 0) {
          result[i][j] = obstacleGrid[i][j] == 1 ? 0 : result[i][j - 1];
        } else if (j == 0) {
          result[i][j] = obstacleGrid[i][j] == 1 ? 0 : result[i - 1][j];
        } else {
          result[i][j] = obstacleGrid[i][j] == 1 ? 0
              : (result[i][j - 1] + result[i - 1][j]);
        }
      }
    }
    return result[m - 1][n - 1];
  }
}