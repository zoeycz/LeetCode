package valid_parentheses;

import java.util.Stack;

/**
 * Valid Parentheses
 * http://oj.leetcode.com/problems/valid-parentheses/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * Solution: Use a Stack to cache the opening signs, whenever see a closing
 * sign, pop and match.
 * 
 * Complexity: Time - O(n), Space - O(n)
 * 
 * Attention: After a pass through the string, the stack should be empty.
 * 
 * @author CAI Zhe
 */
public class Solution {
  public boolean isValid(String s) {
    if (s == null || s.length() == 0)
      return true;
    if (s.length() % 2 == 1)
      return false;

    Stack<Character> stack = new Stack<Character>();
    char current;
    for (int i = 0; i < s.length(); i++) {
      current = s.charAt(i);
      if (isClosingSign(current)) {
        if (stack.isEmpty())
          return false;
        if (!matches(stack.pop(), current))
          return false;
      } else {
        stack.push(current);
      }
    }
    if (!stack.isEmpty())
      return false;
    return true;
  }

  private boolean matches(char fromStack, char current) {
    if (fromStack == '(' && current == ')' || fromStack == '['
        && current == ']' || fromStack == '{' && current == '}')
      return true;
    return false;
  }

  private boolean isClosingSign(char c) {
    if (c == ')' || c == ']' || c == '}') {
      return true;
    }
    return false;
  }
}