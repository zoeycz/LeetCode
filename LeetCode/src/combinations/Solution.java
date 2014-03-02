package combinations;

import java.util.ArrayList;

/**
 * Combinations
 * http://oj.leetcode.com/problems/combinations/
 * 
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * Solution: Recursively solving. When k == 0, stop and return.
 * Otherwise, add a non-repetitive element and solve (n, k-1).
 * 
 * Complexity: Time - O(2^N), Space - O(2^N)
 * O((n, k)) = O(2^n), O(n!) = O(n^n), O(nPk) = O(n^n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  private ArrayList<ArrayList<Integer>> res;

  public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    res = new ArrayList<ArrayList<Integer>>();

    // Optimization : solve(n, n-k) if k > n/2.
    if (k > n / 2) {
      combineHelper(n, n - k);
      getComplement(n);
    } else {
      combineHelper(n, k);
    }
    return res;
  }

  private void combineHelper(int n, int k) {
    if (k == 0) {
      return;
    } else {
      if (res.size() == 0) {
        // Optimization : i <= n-k+1 instead of i <= n
        for (int i = 1; i <= n - k + 1; i++) {
          ArrayList<Integer> tmp = new ArrayList<Integer>();
          tmp.add(i);
          res.add(tmp);
        }
      } else {
        ArrayList<ArrayList<Integer>> helper = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> list : res) {
          // Optimization: add element in increasing order instead of
          // duplication detection
          int x = list.get(list.size() - 1);
          for (int i = x + 1; i <= n; i++) {
            list.add(i);
            helper.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
          }
        }
        res = helper;
      }
      combineHelper(n, k - 1);
    }
  }

  private void getComplement(int n) {
    ArrayList<Integer> all = new ArrayList<Integer>();
    for (int i = 1; i <= n; i++) {
      all.add(i);
    }

    if (res.size() == 0) {
      res.add(all);
      return;
    }

    ArrayList<ArrayList<Integer>> helper = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> tmp;
    for (ArrayList<Integer> list : res) {
      tmp = new ArrayList<Integer>(all);
      tmp.removeAll(list);
      helper.add(tmp);
    }
    res = helper;
  }
}