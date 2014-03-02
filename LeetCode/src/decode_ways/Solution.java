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
 * 
 * Complexity: Time - O(n), Space - O(n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }
    int n = s.length();
    int[] helper = new int[n + 1];
    helper[0] = 1;
    helper[1] = 1;
    char pred = s.charAt(0);
    char curr;
    for (int i = 1; i < n; i++) {
      curr = s.charAt(i);
      if (curr != '0') {
        helper[i + 1] = helper[i];
      }
      if (pred == '1' || (pred == '2' && (curr >= '0' && curr <= '6'))) {
        helper[i + 1] += helper[i - 1];
      }
      pred = curr;
    }
    return helper[n];
  }
}