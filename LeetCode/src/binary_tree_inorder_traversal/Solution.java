package binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.Stack;

import auxiliary_data_structure.TreeNode;

/**
 * Binary Tree Inorder Traversal
 * http://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Solution: Non-recursive solution with Stack.
 * A boolean, popMode, to indicate whether left subtree has all been visited.
 * If not, push right and current node, set current to its left child till null.
 * Then change into popMode, where current set to stack.pop() and record it.
 * Check if the stack top is current.right.
 * If so, current = pop() and turn into non-popMode. Else, enter next loop.
 * 
 * Attention: Not change tree structure in process, good for multi-thread.
 * 
 * Complexity: Time - O(n), Space - O(n)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode current = root;
    boolean popMode = false;

    while (true) {
      if (popMode == false) {
        if (current.right != null) {
          stack.push(current.right);
        }
        stack.push(current);
        if (current.left != null) {
          current = current.left;
        } else {
          popMode = true;
        }
      } else {
        current = stack.pop();
        result.add(current.val);
        if (stack.isEmpty()) {
          break;
        }
        if (stack.peek() == current.right) {
          current = stack.pop();
          popMode = false;
        }
      }
    }
    return result;
  }
}
