package generate_parentheses;

import java.util.ArrayList;

/**
 * Generate Parentheses
 * http://oj.leetcode.com/problems/generate-parentheses/
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * Solution: Recursively add one char at a time.
 * Keep track of the total left and right parentheses to ensure correctness.
 * 
 * Complexity: Time - O(4^n), Space - O(n)
 * O((2n-1, n)) = O(2^2n) = O(4^n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  private ArrayList<String> res;

  public ArrayList<String> generateParenthesis(int n) {
    res = new ArrayList<String>();
    if (n < 0)
      return res;
    if (n == 0) {
      res.add("");
      return res;
    }

    generateHelper("", 0, 0, n);
    return res;
  }

  private void generateHelper(String s, int l, int r, int n) {
    if (r == n) {
      res.add(s);
    }
    if (l < n) {
      generateHelper(s + "(", l + 1, r, n);
    }
    if (r < l) {
      generateHelper(s + ")", l, r + 1, n);
    }
  }
}