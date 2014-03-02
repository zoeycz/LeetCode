package subsets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Subsets
 * http://oj.leetcode.com/problems/subsets/
 * 
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * Solution: There are altogether 2^n subsets.
 * Use n-digit number as a mask to determine whether element in subset or not.
 * 
 * Complexity: Time - O(2^n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    int size = S.length;
    if (size == 0) {
      return result;
    }
    Arrays.sort(S);

    int n = 1 << size;
    int k;
    ArrayList<Integer> list;
    for (int i = 0; i < n; i++) {
      k = 0;
      list = new ArrayList<Integer>();
      for (int j = i; j > 0; j /= 2, k++) {
        if (j % 2 == 1) {
          list.add(S[k]);
        }
      }
      result.add(list);
    }
    return result;
  }
}