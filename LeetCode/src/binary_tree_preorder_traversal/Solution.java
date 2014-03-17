package binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.Stack;

import auxiliary_data_structure.TreeNode;

/**
 * Binary Tree Preorder Traversal
 * http://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Solution: Non-recursive solution with Stack.
 * Record current node, push right child to stack, go to left child.
 * If left is null, current is set to stack.pop().
 * 
 * Attention: Not change tree structure in process, good for multi-thread.
 * 
 * Complexity: Time - O(n), Space - O(h)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ArrayList<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> treeNodes = new Stack<TreeNode>();
    TreeNode current = root;

    while (current != null) {
      result.add(current.val);
      if (current.right != null) {
        treeNodes.push(current.right);
      }
      if (current.left != null) {
        current = current.left;
      } else if (!treeNodes.isEmpty()) {
        current = treeNodes.pop();
      } else {
        current = null;
      }
    }
    return result;
  }
}
