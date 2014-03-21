package remove_duplicates_from_sorted_list_ii;

import auxiliary_data_structure.ListNode;

/**
 * Remove Duplicates from Sorted List II
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Solution: Use one boolean to indicate whether current node need to be
 * deleted.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dmp = new ListNode(0);
    dmp.next = head;

    ListNode prev = dmp;
    ListNode curr = head;
    ListNode next;
    boolean dupCurr = false;

    while (curr != null && curr.next != null) {
      next = curr.next;
      if (curr.val == next.val) {
        dupCurr = true;
        curr.next = next.next;
      } else {
        if (dupCurr) {
          prev.next = curr.next;
          dupCurr = false;
        } else {
          prev = curr;
        }
        curr = curr.next;
      }
    }

    if (dupCurr) {
      prev.next = curr == null ? null : curr.next;
    }
    return dmp.next;
  }
}
