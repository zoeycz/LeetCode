package merge_two_sorted_list;

import auxiliary_data_structure.ListNode;

/**
 * Merge Two Sorted List
 * http://oj.leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Solution: The result node linked to the smaller of two heads.
 * 
 * Complexity: Time - O(m+n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;

    ListNode head;
    if (l1.val < l2.val) {
      head = l1;
      l1 = l1.next;
    } else {
      head = l2;
      l2 = l2.next;
    }

    ListNode current = head;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        current.next = l1;
        l1 = l1.next;
      } else {
        current.next = l2;
        l2 = l2.next;
      }
      current = current.next;
    }
    current.next = l1 == null ? l2 : l1;
    return head;
  }
}
