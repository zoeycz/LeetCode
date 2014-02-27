package sqrt_x;

/**
 * Sqrt(x)
 * http://oj.leetcode.com/problems/sqrtx/
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * Solution: Use Newton Iteration Method.
 * 
 * Complexity: Time - O(logN), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int sqrt(int x) {
    if (x < 0) {
      return -1;
    } else if (x == 0 || x == 1) {
      return x;
    }
    // Newton Iteration Method
    double last = 0;
    double current = 1;
    double delta = 0.000001;
    while (Math.abs(last - current) > delta) {
      last = current;
      current = (x / last + last) / 2;
    }
    return (int) current;
  }
}
