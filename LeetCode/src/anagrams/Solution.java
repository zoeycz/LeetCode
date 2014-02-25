package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Anagrams
 * http://oj.leetcode.com/problems/anagrams/
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Solution: Keep a hashtable, with sorted char array as the key to every
 * string.
 * 
 * Complexity: Time - O(n), Space - O(n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ArrayList<String> anagrams(String[] strs) {
    ArrayList<String> result = new ArrayList<String>();
    Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    for (String s : strs) {
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      String key = new String(arr);
      ArrayList<String> list = map.get(key);
      if (list == null) {
        list = new ArrayList<String>();
      }
      list.add(s);
      map.put(key, list);
    }
    for (ArrayList<String> list : map.values()) {
      if (list.size() > 1) {
        result.addAll(list);
      }
    }
    return result;
  }
}
