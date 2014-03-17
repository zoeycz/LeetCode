package binary_tree_postorder_traversal;

import java.util.ArrayList;

import auxiliary_data_structure.TreeNode;

/**
 * Binary Tree Postorder Traversal
 * http://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Solution: Morris Traversal.
 * Use predecessor's null right to cache current ndoe.
 * Change tree structure in process, not good for multi-thread.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */

public class SolutionMT {
  private ArrayList<Integer> result;

  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    TreeNode dump = new TreeNode(0);
    dump.left = root;

    TreeNode cur = dump;
    while (cur != null) {
      if (cur.left == null) {
        cur = cur.right;
      } else {
        TreeNode prev = cur.left;
        while (prev.right != null && prev.right != cur) {
          prev = prev.right;
        }
        if (prev.right == null) {
          prev.right = cur;
          cur = cur.left;
        } else {
          prev.right = null;
          reverseRecord(cur.left, prev);
          cur = cur.right;
        }
      }
    }

    return result;
  }

  private void reverseRecord(TreeNode start, TreeNode end) {
    if (start == end) {
      result.add(start.val);
      return;
    }
    ArrayList<Integer> record = new ArrayList<Integer>();
    while (start != end) {
      record.add(start.val);
      start = start.right;
    }
    record.add(start.val);

    for (int i = record.size() - 1; i >= 0; i--) {
      result.add(record.get(i));
    }
  }
}
