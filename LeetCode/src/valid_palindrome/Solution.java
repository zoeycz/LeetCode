package valid_palindrome;

/**
 * Valid Palindrome
 * http://oj.leetcode.com/problems/valid-palindrome/
 * 
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Solution: Process the string and compare two halves.
 * 
 * Complexity: Time - O(n), Space - O(n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    String ss = trim(s);
    return isPalindromeHelper(ss);
  }

  private boolean isPalindromeHelper(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    int size = s.length();
    for (int i = 0; i < size / 2; i++) {
      if (s.charAt(i) != s.charAt(size - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  private String trim(String s) {
    StringBuilder sb = new StringBuilder();
    char c;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
        sb.append(c);
      } else if (c >= 'A' && c <= 'Z') {
        c = (char) (c - 'A' + 'a');
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
