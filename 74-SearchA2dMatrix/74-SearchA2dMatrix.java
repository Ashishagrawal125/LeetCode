// Last updated: 8/27/2025, 12:54:13 PM
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Check if the matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Start from the top-right corner
        int row = 0;
        int col = n - 1;
        
        // Loop until the row or column goes out of bounds
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;  // Target found
            } else if (matrix[row][col] > target) {
                col--;  // Move left
            } else {
                row++;  // Move down
            }
        }
        
        // If we exit the loop, the target is not in the matrix
        return false;
    }
}
