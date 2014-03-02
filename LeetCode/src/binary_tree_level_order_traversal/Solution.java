package binary_tree_level_order_traversal;

import java.util.ArrayList;

import auxiliary_data_structure.TreeNode;

/**
 * Binary Tree Level Order Traversal
 * http://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * Solution: BFS tree into an ArrayList, use null to separate two level.
 * Keep count of consecutive nulls to detection traversal end.
 * 
 * Optimization: Helper tree can be used directly to get the final result to
 * improve extra space usage from O(n) to O(1).
 * 
 * Complexity: Time - O(n), Space - O(n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  private ArrayList<TreeNode> tree;

  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return result;
    }

    tree = new ArrayList<TreeNode>();
    levelTree(root);

    ArrayList<Integer> level = new ArrayList<Integer>();
    for (TreeNode node : tree) {
      if (node != null) {
        level.add(node.val);
      } else {
        result.add(level);
        level = new ArrayList<Integer>();
      }
    }
    return result;
  }

  private void levelTree(TreeNode root) {
    tree.add(root);
    tree.add(null);
    TreeNode current = root;
    TreeNode last = root;
    for (int i = 0;; i++) {
      current = tree.get(i);
      if (last == null && current == null) {
        break;
      }
      if (current == null) {
        tree.add(null);
      } else {
        if (current.left != null) {
          tree.add(current.left);
        }
        if (current.right != null) {
          tree.add(current.right);
        }
      }
      last = current;
    }
    tree.remove(tree.size() - 1);
  }
}