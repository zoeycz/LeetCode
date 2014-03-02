package sum_root_to_leaf_numbers;

import auxiliary_data_structure.TreeNode;

/**
 * Sum Root to Leaf Numbers
 * http://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * 
 * Solution: DFS. Parse current node and number as parameter.
 * When encounter a leaf, add to sum.
 * 
 * Complexity: Time - O(E), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  private int sum;

  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }

    sum = 0;
    traversal(root, 0);

    return sum;
  }

  private void traversal(TreeNode root, int num) {
    num = num * 10 + root.val;
    if (root.left == null && root.right == null) {
      sum += num;
    } else {
      if (root.left != null) {
        traversal(root.left, num);
      }
      if (root.right != null) {
        traversal(root.right, num);
      }
    }
  }
}
