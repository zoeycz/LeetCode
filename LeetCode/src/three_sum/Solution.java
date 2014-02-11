package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3Sum
 * http://oj.leetcode.com/problems/3sum/
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Solution: Sort the array.
 * Iterate the first element, the other two elements comes from the head and
 * tail of the rest array.
 * According to the result, make step improvement on one side.
 * Add result to a Set to get rid of duplicates.
 * 
 * Complexity: Time - O(NlogN), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    if (num == null || num.length < 3)
      return new ArrayList<ArrayList<Integer>>();

    Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
    Arrays.sort(num);
    for (int k = 0; k < num.length - 2; k++) {
      int i = k + 1;
      int j = num.length - 1;
      ArrayList<Integer> list;
      int sum;
      while (i < j) {
        sum = num[k] + num[i] + num[j];
        if (sum == 0) {
          list = new ArrayList<Integer>();
          list.add(num[k]);
          list.add(num[i]);
          list.add(num[j]);
          set.add(list);
          i++;
          j--;
        } else if (sum > 0) {
          j--;
        } else {
          i++;
        }
      }
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(set);
    return res;
  }
}