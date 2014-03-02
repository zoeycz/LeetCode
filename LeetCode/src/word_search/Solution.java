package word_search;

/**
 * Word Search
 * http://oj.leetcode.com/problems/word-search/
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Solution: DFS. Start from one match, label it as used,
 * recursively check the non-labeled neighbor match the next letter or not.
 * If not find an answer, unlabel the current location and continue.
 * 
 * Complexity: Time - O(m*n*4^len), Space - O(m*n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  private char[][] board;
  private String word;
  private int m;
  private int n;
  private boolean[][] used;

  public boolean exist(char[][] board, String word) {
    if (word == null || word == "") {
      return true;
    }
    this.board = board;
    this.word = word;
    m = board.length;
    n = board[0].length;
    if (word.length() > m * n) {
      return false;
    }
    used = new boolean[m][n];
    char c = word.charAt(0);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (c == board[i][j]) {
          if (existHelper(i, j, 1)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean existHelper(int i, int j, int index) {
    if (index == word.length()) {
      return true;
    }
    used[i][j] = true;

    char current = word.charAt(index);
    if (i > 0 && current == board[i - 1][j] && used[i - 1][j] == false) {
      if (existHelper(i - 1, j, index + 1)) {
        return true;
      }
    }
    if (j > 0 && current == board[i][j - 1] && used[i][j - 1] == false) {
      if (existHelper(i, j - 1, index + 1)) {
        return true;
      }
    }
    if (i < m - 1 && current == board[i + 1][j] && used[i + 1][j] == false) {
      if (existHelper(i + 1, j, index + 1)) {
        return true;
      }
    }
    if (j < n - 1 && current == board[i][j + 1] && used[i][j + 1] == false) {
      if (existHelper(i, j + 1, index + 1)) {
        return true;
      }
    }

    used[i][j] = false;
    return false;
  }
}