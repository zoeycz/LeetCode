package validate_binary_search_tree;

/**
 * Validate Binary Search Tree
 * http://oj.leetcode.com/problems/validate-binary-search-tree/
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * - The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * - Both the left and right subtrees must also be binary search trees.
 * 
 * Solution: DFS, carry on boundary to child leaves.
 * 
 * Complexity: Time - O(n), Space - O(logN)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public boolean isValidBST(TreeNode root) {
    return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  boolean isValidBSTHelper(TreeNode root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.val <= min || root.val >= max) {
      return false;
    }
    return isValidBSTHelper(root.left, min, root.val)
        && isValidBSTHelper(root.right, root.val, max);
  }
}
