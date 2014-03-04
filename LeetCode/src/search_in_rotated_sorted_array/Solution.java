package search_in_rotated_sorted_array;

/**
 * Search in Rotated Sorted Array
 * http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * Solution: Binary Search. Keep track of current range by left, right index.
 * Calculate mid accordingly, based on elements of left, mid, right to decide
 * which half is well-ordered part or containing pivot.
 * Comparing target with mid and decide how to update left and right.
 * 
 * Attention: No duplicates is important, Otherwise, when you compared with mid,
 * it's hard to decide to go left or right next.
 * 
 * Complexity: Time - O(logN), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int search(int[] A, int target) {
    if (A.length == 0) {
      return -1;
    }

    // left and right are used to indicate current process range
    int left = 0;
    int right = A.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (A[mid] == target) {
        return mid;
      } else {
        // left half is regular
        if (A[left] <= A[mid]) {
          // target in right half
          if (target > A[mid]) {
            left = mid + 1;
          }
          // target is smaller than mid;
          // in regular left or rotated to right
          else {
            // in regular left
            if (target >= A[left]) {
              right = mid - 1;
            }
            // rotated to right
            else {
              left = mid + 1;
            }
          }
        }
        // right half is regular
        else {
          // target in left half
          if (target < A[mid]) {
            right = mid - 1;
          }
          // target is larger than mid;
          // in regular right or rotated to left
          else {
            // in regular right
            if (target <= A[right]) {
              left = mid + 1;
            }
            // rotated to left
            else {
              right = mid - 1;
            }
          }
        }
      }
    }
    return -1;
  }
}
