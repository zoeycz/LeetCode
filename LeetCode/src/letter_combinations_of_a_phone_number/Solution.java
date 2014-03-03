package letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * http://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Solution: Transform each input number as a list of characters.
 * One input number map to a level of tree.
 * DFS the tree to get all possible path.
 * 
 * Complexity: Time - O(3^n), Space - O(n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  private ArrayList<List<Character>> list = new ArrayList<List<Character>>();
  private ArrayList<String> res = new ArrayList<String>();

  public ArrayList<String> letterCombinations(String digits) {
    str2list(digits);
    dfs(list, 0, "");
    return res;
  }

  /**
   * List served as a tree, dfs and record path in s.
   * @param list Characters for each phone button
   * @param level current dfs level
   * @param s dfs path so far
   */
  private void dfs(ArrayList<List<Character>> list, int level, String s) {
    int m = list.size();
    if (level == m) {
      res.add(s);
    } else {
      for (char c : list.get(level)) {
        dfs(list, level + 1, s + c);
      }
    }
  }

  /**
   * For every number in s, get associated list of characters and store into
   * list.
   * @param s Phone button input string
   */
  private void str2list(String s) {
    char[] array = s.toCharArray();
    for (char c : array) {
      List<Character> l = getChar(char2num(c));
      list.add(l);
    }
  }

  private int char2num(char c) {
    return c - '0';
  }

  /**
   * A method to get the associated characters for a certain number.
   * @param num Telephone button input
   * @return The associated characters
   */
  private List<Character> getChar(int num) {
    List<Character> res = new LinkedList<Character>();
    if (num < 2 || num > 9) {
      res.add(' ');
    } else if (num <= 7) {
      for (int i = 0; i < 3; i++) {
        res.add((char) ((num - 2) * 3 + 'a' + i));
      }
      if (num == 7) {
        res.add('s');
      }
    } else {
      for (int i = 0; i < 3; i++) {
        res.add((char) ((num - 2) * 3 + 'a' + i + 1));
      }
      if (num == 9) {
        res.add('z');
      }
    }
    return res;
  }
}
