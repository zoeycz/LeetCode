package palindrome_partitioning;

import java.util.ArrayList;

/**
 * Palindrom Partitioning
 * http://oj.leetcode.com/problems/palindrome-partitioning/
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * Solution: If s.substring(0, i) is palindrome, recursively solve
 * P(s.substring(i)), combine them to get result.
 * 
 * Complexity: Time - O(NlogN / 2^N), Space - O(2^N)
 * T(n) = k/2 * T(n-k), T(1) = 1
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ArrayList<ArrayList<String>> partition(String s) {
    ArrayList<ArrayList<String>> result = biPartition(s);
    return result;
  }

  private ArrayList<ArrayList<String>> biPartition(String s) {
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    if (s.length() == 0) {
      return result;
    }
    ArrayList<String> list;
    if (s.length() == 1) {
      list = new ArrayList<String>();
      list.add(s);
      result.add(list);
      return result;
    }
    for (int i = 1; i < s.length(); i++) {
      if (isPalindrome(s.substring(0, i))) {
        ArrayList<ArrayList<String>> tail = biPartition(s.substring(i,
            s.length()));
        if (tail.size() > 0) {
          for (ArrayList<String> l : tail) {
            list = new ArrayList<String>();
            list.add(s.substring(0, i));
            list.addAll(l);
            result.add(list);
          }
        }
      }
    }
    if (isPalindrome(s)) {
      list = new ArrayList<String>();
      list.add(s);
      result.add(list);
    }
    return result;
  }

  private boolean isPalindrome(String s) {
    char[] charArray = s.toCharArray();
    int length = charArray.length;
    for (int i = 0; i < (length + 1) / 2; i++) {
      if (charArray[i] != charArray[length - 1 - i]) {
        return false;
      }
    }
    return true;
  }
}
