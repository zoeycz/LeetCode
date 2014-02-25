package add_binary;

/**
 * Add Binary
 * http://oj.leetcode.com/problems/add-binary/
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * Solution: Go through the list and keep a carry. Don't forget to add one bit
 * if there's carry after the length of list.
 * 
 * Complexity: Time - O(n), Space - O(n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public String addBinary(String a, String b) {
    if (a.length() < b.length()) {
      String s = a;
      a = b;
      b = s;
    }

    int i = 0;
    int aLen = a.length();
    int bLen = b.length();
    boolean carry = false;
    StringBuilder sb = new StringBuilder();
    int x, y, sum;

    for (; i < bLen; i++) {
      x = a.charAt(aLen - 1 - i) - '0';
      y = b.charAt(bLen - 1 - i) - '0';
      sum = x + y;
      if (carry)
        sum++;
      carry = false;
      if (sum > 1) {
        carry = true;
        sum %= 2;
      }
      char c = (char) ('0' + sum);
      sb.insert(0, c);
    }
    for (; i < aLen; i++) {
      sum = a.charAt(aLen - 1 - i) - '0';
      if (carry)
        sum++;
      carry = false;
      if (sum > 1) {
        carry = true;
        sum %= 2;
      }
      char c = (char) ('0' + sum);
      sb.insert(0, '0' + sum);
    }
    if (carry) {
      sb.insert(0, '0' + 1);
    }
    return sb.toString();
  }
}
