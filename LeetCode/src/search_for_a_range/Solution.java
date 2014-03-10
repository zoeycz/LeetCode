package search_for_a_range;

/**
 * Search for a Range
 * http://oj.leetcode.com/problems/search-for-a-range/
 * 
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Solution: Use binary search to hit target number with mid.
 * Parse current high, low, mid for another binary search to narrow down range.
 * 
 * Complexity: Time - O(logN), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  int[] noFound = { -1, -1 };

  public int[] searchRange(int[] A, int target) {
    if (A.length == 0 || target < A[0] || target > A[A.length - 1]) {
      return noFound;
    }
    int[] B = searchNum(A, target);
    if (B.length == 2) {
      return noFound;
    }
    return narrowRange(A, target, B);
  }

  private int[] narrowRange(int[] A, int target, int[] B) {
    int mid;
    int lLow = B[1];
    int lUp = B[0];
    while (lLow < lUp) {
      mid = (lLow + lUp) / 2;
      if (target > A[mid]) {
        lLow = mid + 1;
      } else {
        lUp = mid;
      }
    }
    int uLow = B[0];
    int uUp = B[2];
    while (uLow < uUp) {
      mid = (uLow + uUp + 1) / 2;
      if (target < A[mid]) {
        uUp = mid - 1;
      } else {
        uLow = mid;
      }
    }

    int[] C = { lUp, uLow };
    return C;
  }

  private int[] searchNum(int[] A, int target) {
    int low = 0;
    int up = A.length - 1;
    int mid;
    while (low <= up) {
      mid = (low + up) / 2;
      if (target == A[mid]) {
        int[] range = { mid, low, up };
        return range;
      } else if (target > A[mid]) {
        low = mid + 1;
      } else {
        up = mid - 1;
      }
    }
    return noFound;
  }
}
