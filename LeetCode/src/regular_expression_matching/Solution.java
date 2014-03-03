package regular_expression_matching;

import java.util.ArrayList;
import java.util.List;

/**
 * Regular Expression Matching
 * http://oj.leetcode.com/problems/regular-expression-matching/
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * Solution: DP. Use two dimension helper matrix.
 * First process regular expression. Generate two result, one string with no *,
 * one list of boolean to indicate whether this character used to associated
 * with *.
 * Second initialize the matrix with first line and column. Don't forget to add
 * one column at beginning for starting non-match with *.
 * Last process the whole match according to regular expression rules.
 * Return the last element in matrix as result for two strings.
 * 
 * Complexity: Time - O(mn), Space - O(mn)
 * 
 * @author CAI Zhe
 */
public class Solution {
  private List<Boolean> star;

  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }
    int n = s.length();
    int m = p.length();

    // corner cases
    if (n == 0 && m == 0)
      return true;
    if (m == 0) {
      return false;
    }

    p = process(p);

    // corner cases
    if (n == 0) {
      for (boolean b : star) {
        if (!b)
          return false;
      }
      return true;
    }

    // DP helper matrix
    m = p.length();
    boolean[][] match = new boolean[m][n + 1];

    // initialize first column
    match[0][0] = star.get(0);
    if (match[0][0]) {
      for (int i = 1; i < m; i++) {
        match[i][0] = match[i - 1][0] && star.get(i) ? true : false;
      }
    }
    // initialize first line
    match[0][1] = (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) ? true
        : false;
    if (match[0][1] && star.get(0)) {
      for (int j = 2; j < n + 1; j++) {
        if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(j - 1)) {
          match[0][j] = true;
        } else {
          break;
        }
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n + 1; j++) {
        // current char associated with *, zero, one, or multiple match
        if (star.get(i)) {
          if (match[i - 1][j]
              || (match[i][j - 1] && (p.charAt(i) == '.' || p.charAt(i) == s
                  .charAt(j - 1)))) {
            match[i][j] = true;
          }
        }
        // current char not associated with *, regular match
        else {
          if (match[i - 1][j - 1]
              && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j - 1))) {
            match[i][j] = true;
          }
        }
      }
    }

    return match[m - 1][n];
  }

  /**
   * According to input p, generate two out put, one string with no * and one
   * List<Boolean> star label which character associated with *.
   * @param p The input regular expression
   * @return A string with no star
   */
  private String process(String p) {
    star = new ArrayList<Boolean>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < p.length() - 1; i++) {
      sb.append(p.charAt(i));
      if (p.charAt(i + 1) == '*') {
        star.add(true);
        i++;
      } else {
        star.add(false);
      }
    }
    if (p.charAt(p.length() - 1) != '*') {
      sb.append(p.charAt(p.length() - 1));
      star.add(false);
    }
    return sb.toString();
  }
}
