package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Combination Sum
 * http://oj.leetcode.com/problems/combination-sum/
 * 
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
 * Optimization: Use a hashtable to cache calculated combination.
 * 
 * Complexity: Cached result combined with small elements need to be sorted to
 * get rid of duplicates.
 * 
 * @author CAI Zhe
 */
public class SolutionDP {
  private Map<Integer, Set<ArrayList<Integer>>> map;

  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
      int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Arrays.sort(candidates);
    map = new HashMap<Integer, Set<ArrayList<Integer>>>();

    Set<ArrayList<Integer>> set = getCombination(candidates, target);
    if (set.size() == 0) {
      return result;
    }
    return new ArrayList<ArrayList<Integer>>(set);
  }

  Set<ArrayList<Integer>> getCombination(int[] candidates, int target) {
    Set<ArrayList<Integer>> result = map.get(target);
    if (result != null) {
      return result;
    }
    result = new HashSet<ArrayList<Integer>>();
    ArrayList<Integer> list;
    for (int i = candidates.length - 1; i >= 0; i--) {
      if (candidates[i] == target) {
        list = new ArrayList<Integer>();
        list.add(candidates[i]);
        result.add(list);
      } else if (candidates[i] < target) {
        Set<ArrayList<Integer>> set;
        set = getCombination(candidates, target - candidates[i]);
        if (set.size() > 0) {
          for (ArrayList<Integer> inSet : set) {
            list = new ArrayList<Integer>();
            list.addAll(inSet);
            list.add(candidates[i]);
            Collections.sort(list);
            result.add(list);
          }
        }
      }
    }
    map.put(target, result);
    return result;
  }
}
