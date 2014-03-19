package maximum_subarray;

/**
 * Maximum Subarray
 * http://oj.leetcode.com/problems/maximum-subarray/
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * Solution: Keep track of subtotal. If it's less than 0, reset it.
 * If it's larger than max, set max to subtotal.
 * Don't forget the case of negative numbers.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int maxSubArray(int[] A) {
    if (A.length == 0) {
      return 0;
    }
    if (A.length == 1) {
      return A[0];
    }

    int subtotal = A[0];
    int max = subtotal;
    for (int i = 1; i < A.length; i++) {
      if (max < 0 && A[i] > subtotal) {
        subtotal = A[i];
        max = subtotal;
      } else if (max >= 0) {
        subtotal += A[i];
        if (subtotal < 0) {
          subtotal = 0;
        } else if (subtotal > max) {
          max = subtotal;
        }
      }

    }
    return max;
  }
}
