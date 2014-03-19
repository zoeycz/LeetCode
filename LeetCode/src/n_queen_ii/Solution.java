package n_queen_ii;

/**
 * N Queens II
 * http://oj.leetcode.com/problems/n-queens-ii/
 * 
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 * 
 * Solution: DFS. Use iteration to go through all possible position in a line.
 * If valid, recursively call dfs on next line.
 * 
 * Complexity: Time - O(n^3), Space - O(n^2)
 * 
 * @author CAI Zhe
 */
public class Solution {
  private int sum = 0;

  public int totalNQueens(int n) {
    if (n <= 0) {
      return -1;
    }
    int[] board = new int[n];
    dfs(board, 0, n);
    return sum;
  }

  private void dfs(int board[], int cur, int n) {
    if (cur == n) {
      sum++;
      return;
    }
    for (int i = 0; i < n; i++) {
      board[cur] = i;
      if (isValid(board, cur)) {
        dfs(board, cur + 1, n);
      }
    }
  }

  private boolean isValid(int board[], int cur) {
    for (int i = 0; i < cur; i++) {
      if (board[i] == board[cur]
          || Math.abs(board[i] - board[cur]) == Math.abs(i - cur)) {
        return false;
      }
    }
    return true;
  }
}
