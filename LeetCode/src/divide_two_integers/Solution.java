package divide_two_integers;

import java.util.Stack;

/**
 * Divide Two Integers
 * http://oj.leetcode.com/problems/divide-two-integers/
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * Solution: The number of minus of divisor from dividend till it is smaller
 * than dividend is the result of divide.
 * To minimize the number of minus, double divisor by << if it is smaller than
 * dividend. Keep it in a stack for later minus. The stack size indicate how
 * many times the current number is larger than divisor.
 * 
 * Complexity: Time - O(logN), Space - O(logN)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int divide(int dividend, int divisor) {
    if (dividend == 0)
      return 0;
    boolean negative = dividend < 0 && divisor > 0 || dividend > 0
        && divisor < 0;
    long dvd = dividend < 0 ? 0 - (long) dividend : dividend;
    long dvs = divisor < 0 ? 0 - (long) divisor : divisor;

    Stack<Long> stack = new Stack<Long>();
    while (dvs <= dvd && dvs > 0) {
      stack.push(dvs);
      dvs <<= 1;
    }

    int res = 0;
    long num;
    while (!stack.isEmpty()) {
      num = stack.peek();
      if (num > dvd) {
        stack.pop();
      } else {
        dvd -= num;
        res += 1 << (stack.size() - 1);
      }
    }

    res = negative ? 0 - res : res;
    return res;
  }
}
