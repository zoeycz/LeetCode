package merge_k_sorted_lists;

import java.util.ArrayList;

/**
 * Merge k Sorted Lists
 * http://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Solution: Build a minHeap with k list head.
 * Use min node as next list node.
 * Substitute heap top with the next node in sorted list.
 * 
 * Complexity: Time - O(NlogK), Space - O(k)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if (lists == null || lists.size() == 0) {
      return null;
    }

    ListNode[] heap = buildHeap(lists);
    ListNode head = heap[1];
    ListNode last = heap[1];

    while (last != null) {
      heap[1] = last.next;
      minHeapify(heap, 1, 2, 3);
      last.next = heap[1];
      last = last.next;
    }

    return head;
  }

  /**
   * Build a heap from index 1.
   * Left child = 2 * root; right child = 2 * root + 1; root = child / 2
   */
  private ListNode[] buildHeap(ArrayList<ListNode> lists) {
    ListNode[] heap = new ListNode[lists.size() + 1];
    for (int i = 1; i < heap.length; i++) {
      heap[i] = lists.get(i - 1);
    }

    // Max-heapify from last parent
    for (int i = (heap.length - 1) / 2; i > 0; i--) {
      minHeapify(heap, i, i * 2, i * 2 + 1);
    }
    return heap;
  }

  private void minHeapify(ListNode[] heap, int parent, int lChild, int rChild) {
    int size = heap.length;
    if (lChild < size && heap[lChild] != null
        && (heap[parent] == null || heap[lChild].val < heap[parent].val)) {
      exchange(heap, parent, lChild);
      minHeapify(heap, lChild, 2 * lChild, 2 * lChild + 1);
    }
    if (rChild < size && heap[rChild] != null
        && (heap[parent] == null || heap[rChild].val < heap[parent].val)) {
      exchange(heap, parent, rChild);
      minHeapify(heap, rChild, 2 * rChild, 2 * rChild + 1);
    }
  }

  private void exchange(ListNode[] heap, int a, int b) {
    ListNode tmp = heap[a];
    heap[a] = heap[b];
    heap[b] = tmp;
  }
}
