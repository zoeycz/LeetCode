package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Merge Intervals
 * http://oj.leetcode.com/problems/merge-intervals/
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Solution: Sort all start and end. 
 * Check intersect of neighboring start and end.
 * 
 * Complexity: Time - O(NlogN), Space - O(N);
 * 
 * @author CAI Zhe
 */
public class Solution {
  private int[] start;
  private int[] end;
  private ArrayList<Interval> res;

  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    res = new ArrayList<Interval>();
    if (intervals == null || intervals.size() == 0)
      return res;
    int size = intervals.size();
    start = new int[size];
    end = new int[size];
    processIntervals(intervals);
    mergeHelper();
    return res;
  }

  private void mergeHelper() {
    int i = 0;
    int begin = 0;
    while (i < start.length - 1) {
      if (end[i] < start[i + 1]) {
        Interval itv = new Interval(start[begin], end[i]);
        res.add(itv);
        begin = i + 1;
      }
      i++;
    }
    Interval itv = new Interval(start[begin], end[i]);
    res.add(itv);
  }

  private void processIntervals(ArrayList<Interval> intervals) {
    for (int i = 0; i < intervals.size(); i++) {
      start[i] = intervals.get(i).start;
      end[i] = intervals.get(i).end;
    }
    Arrays.sort(start);
    Arrays.sort(end);
  }
}