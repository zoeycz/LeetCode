package climbing_stairs;

/**
 * Climbing Stairs
 * http://oj.leetcode.com/problems/climbing-stairs/
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Solution: climbStairs(n) = climbStairs(n-1) + climbStairs(n-2)
 * Using a helper array to get rid of repeating computation.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * Optimization: Instead of using helper array, use two helper variables to
 * optimize extra space from O(n) to O(1)
 * 
 * @author CAI Zhe
 */

public class Solution {
  public int climbStairs(int n) {
    if (n < 0)
      return 0;
    if (n < 3)
      return n;

    int helper = 0;
    int helper1 = 2;
    int helper2 = 1;
    for (int i = 3; i <= n; i++) {
      helper = helper2 + helper1;
      helper2 = helper1;
      helper1 = helper;
    }
    return helper;
  }
}
