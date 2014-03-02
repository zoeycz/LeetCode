package sum_root_to_leaf_numbers;

import java.util.LinkedList;
import java.util.List;

import auxiliary_data_structure.TreeNode;

public class Solution {
  private List<Integer> list = new LinkedList<Integer>();

  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    traversal(root, 0);
    int sum = 0;
    for (int x : list) {
      sum += x;
    }
    return sum;
  }

  private void traversal(TreeNode root, int num) {
    num = num * 10 + root.val;
    if (root.left == null && root.right == null) {
      list.add(num);
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
