package edit_distance;

/**
 * Edit Distance
 * http://oj.leetcode.com/problems/edit-distance/
 * 
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * Solution: DP. Use a two-dimensional matrix helper to record edit distance.
 * If A[i] == B[j], m[i][j] = m[i-1][j-1];
 * Else, m[i][j] = 1 + min{m[i-1][j-1], m[i][j-1], m[i-1][j]}.
 * Add one additional line and column in helper matrix for initiated value.
 * 
 * Complexity: Time - O(mn), Space - O(mn)
 * 
 * Optimization: DP helper matrix can be compressed into one-dimensional array 
 * plus O(1) space. Therefore, Space - O(m)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int minDistance(String word1, String word2) {
    int m = word1.length() + 1;
    int n = word2.length() + 1;
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      result[i][0] = i;
    }
    for (int i = 1; i < n; i++) {
      result[0][i] = i;
    }

    int edit = 0;
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + 1;
        edit = result[i - 1][j - 1];
        if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
          edit++;
        }
        result[i][j] = Math.min(result[i][j], edit);
      }
    }
    return result[m - 1][n - 1];
  }
}
