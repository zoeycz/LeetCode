package merge_sorted_array;

/**
 * Merge Sorted Array
 * http://oj.leetcode.com/problems/merge-sorted-array/
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Solution: Use the vacant space in the end of A, merge from the larger end.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public void merge(int A[], int m, int B[], int n) {
    if (n < 0 || m < 0 || A.length < m + n) {
      return;
    }

    int i = m - 1;
    int j = n - 1;
    for (int k = m + n - 1; k >= 0; k--) {
      if (i >= 0 && j >= 0) {
        if (A[i] >= B[j]) {
          A[k] = A[i--];
        } else {
          A[k] = B[j--];
        }
      } else if (i < 0) {
        A[k] = B[j--];
      }
    }
  }
}