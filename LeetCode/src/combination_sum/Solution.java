package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Combination Sum
 * http://oj.leetcode.com/problems/combination-sum/
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order.
 * (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 * 
 * Solution: Sort candidates array. Every time try from add the largest element,
 * and see if its complementary elements exists.
 * 
 * Optimization: Use a helper function with end indicates largest element to
 * use. Larger elements may be decomposed into smaller elements in later
 * iteration, but won't be used again to generate duplicates.
 * 
 * Complexity: Better than DP solution in both time and space.
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
      int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Arrays.sort(candidates);
    Set<ArrayList<Integer>> set = getCombination(candidates,
        candidates.length - 1, target);
    if (set.size() == 0) {
      return result;
    }
    return new ArrayList<ArrayList<Integer>>(set);
  }

  Set<ArrayList<Integer>> getCombination(int[] candidates, int end, int target) {
    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
    ArrayList<Integer> list;
    for (int i = end; i >= 0; i--) {
      if (candidates[i] == target) {
        list = new ArrayList<Integer>();
        list.add(candidates[i]);
        result.add(list);
      } else if (candidates[i] < target) {
        Set<ArrayList<Integer>> set;
        set = getCombination(candidates, i, target - candidates[i]);
        if (set.size() > 0) {
          for (ArrayList<Integer> inSet : set) {
            list = new ArrayList<Integer>();
            list.addAll(inSet);
            list.add(candidates[i]);
            result.add(list);
          }
        }
      }
    }
    return result;
  }
}
