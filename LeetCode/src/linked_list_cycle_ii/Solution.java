package linked_list_cycle_ii;

/**
 * Linked List Cycle II
 * http://oj.leetcode.com/problems/linked-list-cycle-ii/
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Solution: Use fast & slow pointers.
 * Fast moves two times faster than the slow.
 * 2*(l+x) = l+x+c => l = c-x
 * When meet, slow start from head again, and each move one step at one time.
 * They will meet at loop start.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * Attention: Before meet, fast has to move two steps before judge.
 * Even if meet when after one step, discard; otherwise, won't get loop start.
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }

    // fast & slow pointers to test if there's loop
    // If head is counted as one step does not matter. But be consistent.
    ListNode slow = head;
    ListNode fast = head;
    do {
      slow = slow.next;
      if (fast.next != null) {
        fast = fast.next.next;
      }
      if (fast == null || fast.next == null) {
        return null;
      }
    } while (slow != fast);

    // track loop start
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}