package reverse_integer;

/**
 * Reverse Integer
 * http://oj.leetcode.com/problems/reverse-integer/
 * 
 * Reverse digits of an integer.
 * 
 * Solution: Use modality to get LSB and accumulate it in another number.
 * 
 * Complexity: Time - O(logN), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int reverse(int x) {
    int y = 0;
    while (x != 0) {
      y *= 10;
      y += x % 10;
      x /= 10;
    }
    return y;
  }
}
