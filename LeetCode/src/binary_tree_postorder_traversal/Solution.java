package binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.Stack;

import auxiliary_data_structure.TreeNode;

/**
 * Binary Tree Postorder Traversal
 * http://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Solution: Non-recursive solution with Stack.
 * A boolean, popMode to indicate left subtree visited.
 * When non visited yet, push right child and current and go to left child till
 * null. Then flip to visited.
 * When visited, current set to stack top.
 * Check whether next top is the right child of current.
 * If so, push current and current set to right child, flip to non visited.
 * Otherwise, record current.
 * 
 * Attention: Not change tree structure in process, good for multi-thread.
 * 
 * Complexity: Time - O(n), Space - O(h)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    Stack<TreeNode> treeNodes = new Stack<TreeNode>();
    TreeNode current = root;
    boolean popMode = false;

    while (true) {
      if (popMode == false) {
        if (current.right != null) {
          treeNodes.push(current.right);
        }
        treeNodes.push(current);
        if (current.left != null) {
          current = current.left;
        } else {
          popMode = true;
        }
      } else {
        current = treeNodes.pop();
        if (treeNodes.isEmpty()) {
          result.add(current.val);
          break;
        }
        if (treeNodes.peek() == current.right) {
          treeNodes.pop();
          treeNodes.push(current);
          current = current.right;
          popMode = false;
        } else {
          result.add(current.val);
        }
      }
    }
    return result;
  }
}
