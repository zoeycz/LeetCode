package remove_element;

/**
 * Remove Element
 * http://oj.leetcode.com/problems/remove-element/
 * 
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * Solution: Iterate through the array, if element equals to value, swap it with
 * element on tail, update tail(length). Index stay on current location to check
 * this element.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int removeElement(int[] A, int elem) {
    int end = A.length - 1;
    for (int i = 0; i <= end; i++) {
      if (A[i] == elem) {
        A[i] ^= A[end];
        A[end] ^= A[i];
        A[i] ^= A[end];
        i--;
        end--;
      }
    }
    return end + 1;
  }
}
