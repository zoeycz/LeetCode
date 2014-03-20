package search_a_2d_matrix;

/**
 * Search a 2D Matrix
 * http://oj.leetcode.com/problems/search-a-2d-matrix/
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * Solution: Binary Search for the row, then binary search in this row.
 * 
 * Complexity: Time - O(logN + logM), Space - O(1)
 * 
 * @author CAI Zhe
 */
public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
      return false;
    }
    int row = searchRow(matrix, target);
    return binarySearch(matrix, row, target);
  }

  boolean binarySearch(int[][] matrix, int row, int target) {
    int low = 0;
    int up = matrix[0].length - 1;
    int mid;
    while (low <= up) {
      mid = (low + up) / 2;
      if (matrix[row][mid] == target) {
        return true;
      } else if (matrix[row][mid] < target) {
        low = mid + 1;
      } else {
        up = mid - 1;
      }
    }
    return false;
  }

  int searchRow(int[][] matrix, int target) {
    int low = 0;
    int up = matrix.length - 1;
    int n = matrix[0].length;
    int mid;
    while (low < up) {
      mid = (low + up) / 2;
      if (matrix[mid][n - 1] > target) {
        up = mid;
      } else if (matrix[mid][n - 1] == target) {
        return mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
