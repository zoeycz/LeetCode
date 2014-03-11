package n_queens;

import java.util.ArrayList;

/**
 * N Queens
 * http://oj.leetcode.com/problems/n-queens/
 * 
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard
 * such that no two queens attack each other.
 * 
 * Solution: DFS. Use iteration to go through all possible position in a line.
 * If valid, recursively call dfs on next line.
 * 
 * Complexity: Time - O(n^3), Space - O(n^3)
 * 
 * @author CAI Zhe
 */
public class Solution {
  private ArrayList<String[]> solution = new ArrayList<String[]>();

  public ArrayList<String[]> solveNQueens(int n) {
    int[] board = new int[n];
    dfs(board, 0, n);
    return solution;
  }

  private void dfs(int[] board, int cur, int n) {
    if (cur == n) {
      solution.add(int2str(board));
    } else {
      for (int i = 0; i < n; i++) {
        board[cur] = i;
        if (isValid(board, cur)) {
          dfs(board, cur + 1, n);
        }
      }
    }
  }

  private boolean isValid(int[] board, int cur) {
    for (int i = 0; i < cur; i++) {
      if (board[i] == board[cur]
          || Math.abs(board[i] - board[cur]) == Math.abs(i - cur)) {
        return false;
      }
    }
    return true;
  }

  private String[] int2str(int[] board) {
    int n = board.length;
    String[] result = new String[n];
    for (int i = 0; i < n; i++) {
      int x = board[i];
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < n; j++) {
        if (j == x) {
          sb.append("Q");
        } else {
          sb.append(".");
        }
      }
      result[i] = sb.toString();
    }
    return result;
  }
}
