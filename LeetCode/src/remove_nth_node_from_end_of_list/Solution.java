package remove_nth_node_from_end_of_list;

import auxiliary_data_structure.ListNode;

/**
 * Remove Nth Node From End of List
 * http://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * Solution: Use fast and slow two pointers. Fast goes n steps ahead of slow
 * one. When fast reach end, slow is the nth node from end of list.
 * Don't forget to keep a pre-slow node for remove of slow.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode preSlow = null;
    ListNode slow = head;
    ListNode quick = head;
    for (int i = 1; i < n; i++) {
      if (quick == null) {
        return head;
      }
      quick = quick.next;
    }
    while (quick.next != null) {
      quick = quick.next;
      preSlow = slow;
      slow = slow.next;
    }
    // corner case
    if (preSlow == null) {
      head = head.next;
    } else {
      preSlow.next = slow.next;
    }
    return head;
  }
}
