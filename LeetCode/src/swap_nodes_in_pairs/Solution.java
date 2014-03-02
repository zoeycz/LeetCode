package swap_nodes_in_pairs;

import auxiliary_data_structure.ListNode;

/**
 * Swap Nodes in Pairs
 * http://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Solution: Use a helper function to swap the neighbor nodes and return leading
 * one in result.
 * Main function keeps track of loop and link to new pairs.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    head = swapPairsHelper(head);
    ListNode pred = head.next;
    ListNode current = pred.next;
    while (current != null) {
      pred.next = swapPairsHelper(current);
      pred = current;
      if (current.next == null)
        break;
      current = current.next;
    }
    return head;
  }

  private ListNode swapPairsHelper(ListNode first) {
    if (first.next == null) {
      return first;
    }
    ListNode second = first.next;
    first.next = second.next;
    second.next = first;
    return second;
  }
}