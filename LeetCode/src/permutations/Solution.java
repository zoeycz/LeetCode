package permutations;

import java.util.ArrayList;

/**
 * Permutations
 * http://oj.leetcode.com/problems/permutations/
 * Given a collection of numbers, return all possible permutations.
 * Solution: Use a helper function to solve it recursively.
 * For every recursive call, put a number in remainder to prefix group.
 * The code in note stands for another version for O(n^2) space complexity.
 * Complexity: Time - O(n!), Space - O(n)
 * @author CAI Zhe
 */
public class Solution {
  private ArrayList<ArrayList<Integer>> res;

  public ArrayList<ArrayList<Integer>> permute(int[] num) {
    res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> remainder = new ArrayList<Integer>();
    for (int i = 0; i < num.length; i++) {
      remainder.add(num[i]);
    }

    permuteHelper(new ArrayList<Integer>(), remainder);
    return res;
  }

  private void permuteHelper(ArrayList<Integer> prefix,
      ArrayList<Integer> remainder) {
    int n = remainder.size();
    if (n == 0) {
      ArrayList<Integer> list = new ArrayList<Integer>(prefix);
      res.add(list);
      return;
      
      // res.add(prefix);
      // return;
    }

    for (int i = 0; i < n; i++) {
      int current = remainder.get(i);
      prefix.add(current);
      remainder.remove(i);
      permuteHelper(prefix, remainder);
      prefix.remove(prefix.size() - 1);
      remainder.add(i, current);
      
      // ArrayList<Integer> pref = new ArrayList<Integer>(prefix);
      // pref.add(remainder.get(i));
      // ArrayList<Integer> rmd = new ArrayList<Integer>(remainder);
      // rmd.remove(i);
      // permuteHelper(pref, rmd);
    }
  }
}