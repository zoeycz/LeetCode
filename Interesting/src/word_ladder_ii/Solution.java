package word_ladder_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 1. Only one letter can be changed at a time
 * 2. Each intermediate word must exist in the dictionary
 * http://oj.leetcode.com/problems/word-ladder-ii/
 * 
 * Solution: BFS to find shortest ladder from start
 * - a Set used for current level and deleted from dict after this level to get
 * rid of circle, which will not be part of shortest path anyway.
 * - a Map used to record predecessor of current word to construct result
 * DFS to construct result from end
 * 
 * Complexity: Time - O(n), Space - O(n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  private HashSet<String> remainingSet;
  private HashSet<String> currentSet;
  private boolean found;
  private Map<String, List<String>> map;
  private ArrayList<ArrayList<String>> res;
  private String start;
  private String end;

  public ArrayList<ArrayList<String>> findLadders(String start, String end,
      HashSet<String> dict) {

    // initialize
    res = new ArrayList<ArrayList<String>>();
    if (start == null || end == null || dict == null)
      return res;
    if (start == end) {
      ArrayList<String> list = new ArrayList<String>();
      list.add(start);
      res.add(list);
      return res;
    }
    found = false;
    remainingSet = new HashSet<String>(dict);
    currentSet = new HashSet<String>();
    map = new HashMap<String, List<String>>();
    this.start = start;
    this.end = end;

    // bfs - search for ladder
    remainingSet.add(end);
    currentSet.add(start);
    HashSet<String> frontier;
    while (currentSet.size() > 0) {
      remainingSet.removeAll(currentSet);
      frontier = new HashSet<String>(currentSet);
      currentSet.clear();

      for (String s : frontier) {
        changeOne(s);
      }
      if (found)
        break;
    }
    if (!found)
      return res;

    // dfs - construct result
    dfs(end, new LinkedList<String>());
    return res;
  }

  private void dfs(String s, LinkedList<String> list) {
    list.add(0, s);
    if (s == start) {
      ArrayList<String> alist = new ArrayList<String>(list);
      res.add(alist);
    } else {
      for (String ss : map.get(s)) {
        dfs(ss, list);
      }
    }
    list.remove(0);
  }

  private void changeOne(String s) {
    StringBuilder sb;
    for (int i = 0; i < s.length(); i++) {
      sb = new StringBuilder();
      sb.append(s.substring(0, i));
      for (char ch = 'a'; ch <= 'z'; ch++) {
        if (ch == s.charAt(i))
          continue;
        sb.append(ch);
        sb.append(s.substring(i + 1));
        String ss = sb.toString();
        if (ss.equals(end))
          found = true;
        if (remainingSet.contains(ss)) {
          currentSet.add(ss);
          if (!map.containsKey(ss)) {
            List<String> list = new LinkedList<String>();
            list.add(s);
            map.put(ss, list);
          } else {
            List<String> list = map.get(ss);
            list.add(s);
            map.put(ss, list);
          }
        }
        sb.delete(i, s.length());
      }
    }
  }
}
