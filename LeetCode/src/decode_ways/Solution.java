package decode_ways;

/**
 * Decode Ways
 * http://oj.leetcode.com/problems/decode-ways/
 * 
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * 
 * Solution: DP. 
 * One dimension DP could use constant variable instead of one-dimensional array.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * Optimization: Use helper variables instead of helper array to optimize extra
 * space from O(n) to O(1).
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }
    
    int n = s.length();
    char pred = s.charAt(0);
    if (n == 1) {
      if (pred == '0') {
        return 0;
      } else {
        return 1;
      }
    }
    
    int helper = 0;
    int helper2 = 1;
    int helper1 = 1;
    char curr;
    for (int i = 1; i < n; i++) {
      helper = 0;
      curr = s.charAt(i);
      if (curr != '0') {
        helper = helper1;
      }
      if (pred == '1' || (pred == '2' && (curr >= '0' && curr <= '6'))) {
        helper += helper2;
      }
      pred = curr;
      helper2 = helper1;
      helper1 = helper;
    }
    return helper;
  }
}
