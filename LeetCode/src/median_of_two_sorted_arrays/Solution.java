package median_of_two_sorted_arrays;

/**
 * Median of Two Sorted Arrays
 * http://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 * Solution: Transform to find kth element.
 * Get rid of half of one array every time.
 * 
 * Complexity: Time - O(logMN), Space - O(logMN)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public double findMedianSortedArrays(int A[], int B[]) {
    int aLen = A.length;
    int bLen = B.length;
    if ((aLen + bLen) % 2 == 1) {
      return (double) findKth(A, 0, aLen, B, 0, bLen, (aLen + bLen) / 2);
    } else {
      return ((double) (findKth(A, 0, aLen, B, 0, bLen, (aLen + bLen) / 2 - 1) + findKth(
          A, 0, aLen, B, 0, bLen, (aLen + bLen) / 2))) / 2.0;
    }
  }

  private int findKth(int A[], int aStart, int aLen, int B[], int bStart,
      int bLen, int k) {
    if (aLen == 0)
      return B[bStart + k];
    if (bLen == 0)
      return A[aStart + k];
    if (k == 0)
      return Math.min(A[aStart], B[bStart]);

    if ((aLen / 2 + bLen / 2) < k) {
      if (A[aStart + aLen / 2] <= B[bStart + bLen / 2]) {
        return findKth(A, aStart + aLen / 2 + 1, aLen - aLen / 2 - 1, B,
            bStart, bLen, k - aLen / 2 - 1);
      } else {
        return findKth(A, aStart, aLen, B, bStart + bLen / 2 + 1, bLen - bLen
            / 2 - 1, k - bLen / 2 - 1);
      }
    } else {
      if (A[aStart + aLen / 2] <= B[bStart + bLen / 2]) {
        return findKth(A, aStart, aLen, B, bStart, bLen / 2, k);
      } else {
        return findKth(A, aStart, aLen / 2, B, bStart, bLen, k);
      }
    }
  }
}
