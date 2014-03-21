package search_in_rotated_sorted_array_ii;

/**
 * Search in Rotated Sorted Array II
 * http://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 * Solution: Binary Search.
 * With duplicates, when you compare mid and high, they could be the same, but
 * it's hard to tell where the duplicates chains are.
 * 
 * Complexity: Time - O(n) worst case, Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public boolean search(int[] A, int target) {
    if (A.length == 0) {
      return false;
    }
    int low = 0;
    int high = A.length - 1;
    int mid;
    while (low <= high) {
      mid = (low + high) / 2;
      if (A[mid] == target) {
        return true;
      } else if (A[mid] < target) {
        if (A[mid] < A[high]) {
          if (A[high] >= target) {
            low = mid + 1;
          } else {
            high = mid - 1;
          }
        } else if (A[mid] > A[high]) {
          low = mid + 1;
        } else {
          // A[mid] == A[high] could mean following
          // (mid, high) is same, or (low, mid) is same
          high--;
        }
      } else {
        if (A[low] < A[mid]) {
          if (A[low] <= target) {
            high = mid - 1;
          } else {
            low = mid + 1;
          }
        } else if (A[low] > A[mid]) {
          high = mid - 1;
        } else {
          low++;
        }
      }
    }
    return false;
  }
}
