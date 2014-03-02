package insert_interval;

import java.util.ArrayList;

import auxiliary_data_structure.Interval;

/**
 * Insert Interval
 * http://oj.leetcode.com/problems/insert-interval/
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Solution: Go through the list check if overlapping, merge on the way.
 * If not, insert into right place.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ArrayList<Interval> insert(ArrayList<Interval> intervals,
      Interval newInterval) {
    ArrayList<Interval> result = new ArrayList<Interval>();
    if (intervals == null || intervals.size() == 0) {
      result.add(newInterval);
      return new ArrayList<Interval>(result);
    }
    int start = newInterval.start;
    int end = newInterval.end;

    boolean requireMerge = false;
    boolean mergedAdded = false;
    for (Interval interval : intervals) {
      if (isOverlapped(interval, newInterval)) {
        requireMerge = true;
        start = Math.min(start, interval.start);
        end = Math.max(end, interval.end);
      } else {
        if (requireMerge && !mergedAdded) {
          result.add(new Interval(start, end));
          mergedAdded = true;
        }
        result.add(interval);
      }
    }
    if (requireMerge && !mergedAdded) {
      result.add(new Interval(start, end));
      mergedAdded = true;
    } else if (!requireMerge) {
      for (int i = 0; i < result.size(); i++) {
        if (result.get(i).start > newInterval.start) {
          result.add(i, newInterval);
          mergedAdded = true;
          break;
        }
      }
    }
    if (!mergedAdded) {
      result.add(newInterval);
    }
    return result;
  }

  private boolean isOverlapped(Interval a, Interval b) {
    if (a.end < b.start || b.end < a.start) {
      return false;
    }
    return true;
  }
}