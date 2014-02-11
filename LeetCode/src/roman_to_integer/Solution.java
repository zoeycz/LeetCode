package roman_to_integer;

/**
 * Roman to Integer
 * http://oj.leetcode.com/problems/roman-to-integer/
 * 
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Solution: Read from end to head.
 * Keep track of last number and compared to the current number to decide the
 * sign.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int romanToInt(String s) {
    int count = 0;
    int last = range(s.charAt(s.length() - 1));
    if (last == -1) {
      return 0;
    }
    count += last;

    int current;
    int sign = 1;
    for (int i = s.length() - 2; i >= 0; i--) {
      current = range(s.charAt(i));
      if (current < 0) {
        return 0;
      }
      if (current > last) {
        sign = 1;
      } else if (current < last) {
        sign = -1;
      }
      count += current * sign;
      last = current;
    }
    return count;
  }

  private int range(char c) {
    switch (c) {
    case 'I':
      return 1;
    case 'V':
      return 5;
    case 'X':
      return 10;
    case 'L':
      return 50;
    case 'C':
      return 100;
    case 'D':
      return 500;
    case 'M':
      return 1000;
    default:
      return -1;
    }
  }
}
