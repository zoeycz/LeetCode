package remove_duplicates_from_sorted_array;

/**
 * Remove Duplicates From Sorted Array
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * Solution: Two pointers to go through the array at the same time.
 * Index i to go through the whole array, while index length to get the length
 * of non-duplicates list and maintain it.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int removeDuplicates(int[] A) {
    if (A.length == 0) {
      return 0;
    }
    int length = 0;
    for (int i = 1; i < A.length; i++) {
      if (A[i] != A[length]) {
        length++;
        A[length] = A[i];
      }
    }
    return ++length;
  }
}
