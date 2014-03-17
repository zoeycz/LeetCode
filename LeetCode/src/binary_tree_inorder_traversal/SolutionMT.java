package binary_tree_inorder_traversal;

import java.util.ArrayList;

import auxiliary_data_structure.TreeNode;

/**
 * Binary Tree Inorder Traversal
 * http://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Solution: Morris Traversal.
 * Use predecessor's null right child to cache current information.
 * Change tree structure along the way. Not suitable for multi-thread.
 * 
 * Complexity: Time - O(n), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class SolutionMT {
  public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    TreeNode cur = root;
    while (cur != null) {
      if (cur.left == null) {
        result.add(cur.val);
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
          result.add(cur.val);
          cur = cur.right;
        }
      }
    }

    return result;
  }
}
