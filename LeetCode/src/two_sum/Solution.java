package two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * http://oj.leetcode.com/problems/two-sum/
 * 
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * 
 * Solution: Use a Map to cache number and its index.
 * Go over array and search if the complementary number is ready in the map.
 * If not, cache current one. Else, return result.
 * 
 * Complexity: Time - O(n), Space - O(n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    if (numbers == null || numbers.length < 2)
      return res;

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
      int find = target - numbers[i];
      if (map.containsKey(find)) {
        res[0] = map.get(find) + 1;
        res[1] = i + 1;
        return res;
      } else {
        map.put(numbers[i], i);
      }
    }
    return res;
  }
}