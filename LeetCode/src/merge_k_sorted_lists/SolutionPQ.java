package merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import auxiliary_data_structure.ListNode;

/**
 * Merge k Sorted Lists
 * http://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Solution: Use PriorityQueue defined in Java library to implement min heap.
 * 
 * Complexity: Time - O(NlogK), Space - O(k)
 * 
 * @author CAI Zhe
 */
public class SolutionPQ {
  public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if (lists == null || lists.size() == 0) {
      return null;
    }

    // Define a min heap with PriorityQueue in Java library
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
        new Comparator<ListNode>() {
          @Override
          public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
          }
        });

    for (ListNode n : lists) {
      if (n != null) {
        pq.offer(n);
      }
    }

    ListNode head = new ListNode(0);
    ListNode prev = head;
    while (pq.size() > 0) {
      ListNode tmp = pq.poll();
      prev.next = tmp;
      if (tmp.next != null) {
        pq.offer(tmp.next);
      }
      prev = prev.next;
    }
    return head.next;
  }
}
