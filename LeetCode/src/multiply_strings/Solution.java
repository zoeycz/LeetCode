package multiply_strings;

/**
 * Multiply Strings
 * http://oj.leetcode.com/problems/multiply-strings/
 * 
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * Solution: Simulate old-school multiply by multiply a number to one-digit
 * number and then add up.
 * Optimizations are captured in lines. Don't convert to list.
 * 
 * Complexity: Time - O(mn), Space - O(m)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public String multiply(String num1, String num2) {
    int size = Math.min(num1.length(), num2.length());
    if (size == 0) {
      return "";
    }
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }

    // let num1 to refer to longer string to reduce calls to multiply and add,
    // at cost of more iterations in multiply and add function.
    if (num1.length() < num2.length()) {
      String tmp = num1;
      num1 = num2;
      num2 = tmp;
    }

    String result = multiply(num1, num2.charAt(0), num2.length() - 1);
    for (int i = 1; i < num2.length(); i++) {
      String mul = multiply(num1, num2.charAt(i), num2.length() - 1 - i);
      String sum = add(mul, result);
      result = sum;
    }
    return result;
  }

  String add(String l1, String l2) {
    StringBuffer sb = new StringBuffer();
    int size = Math.max(l1.length(), l2.length());
    int carry = 0;
    for (int i = 0; i < size; i++) {
      int value = 0;
      if (i < l1.length()) {
        value += l1.charAt(l1.length() - 1 - i) - '0';
      }
      if (i < l2.length()) {
        value += l2.charAt(l2.length() - 1 - i) - '0';
      }
      value += carry;
      carry = value / 10;
      value %= 10;
      sb.append(value);
    }
    if (carry > 0) {
      sb.append(carry);
    }
    // append value to tail and reverse here instead of insert to position 0
    return sb.reverse().toString();
  }

  String multiply(String s, char c, int zeros) {
    int x = c - '0';
    StringBuffer sb = new StringBuffer();
    int carry = 0;
    for (int i = 0; i < s.length(); i++) {
      int value = (s.charAt(s.length() - 1 - i) - '0') * x;
      value += carry;
      carry = value / 10;
      value %= 10;
      sb.append(value);
    }
    if (carry > 0) {
      sb.append(carry);
    }
    sb.reverse();
    for (int i = 0; i < zeros; i++) {
      sb.append(0);
    }
    return sb.toString();
  }
}
