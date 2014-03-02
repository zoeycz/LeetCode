package add_two_numbers;

import auxiliary_data_structure.ListNode;

/**
 * Add Two Numbers
 * http://oj.leetcode.com/problems/add-two-numbers/
 * 
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Solution: Record carry at every nodes. When end, check if carry is true,
 * create extra node if necessary.
 * 
 * Complexity: Time - O(n), Space - O(n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    int value = l1.val + l2.val;
    boolean carry = value > 9 ? true : false;
    value %= 10;
    ListNode prev = new ListNode(value);
    ListNode head = prev;
    l1 = l1.next;
    l2 = l2.next;
    while (l1 != null || l2 != null) {
      ListNode current = new ListNode(0);
      prev.next = current;
      if (l1 != null) {
        current.val += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        current.val += l2.val;
        l2 = l2.next;
      }
      if (carry == true) {
        current.val++;
      }
      if (current.val > 9) {
        carry = true;
      } else {
        carry = false;
      }
      current.val %= 10;
      prev = current;
    }
    if (carry == true) {
      ListNode current = new ListNode(1);
      prev.next = current;
    }
    return head;
  }
}
