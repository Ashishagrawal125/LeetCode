// Last updated: 11/8/2025, 11:45:50 PM
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1, max = n * n;
        while (num <= max) {
            for (int j = left; j <= right && num <= max; j++) res[top][j] = num++;
            top++;
            for (int i = top; i <= bottom && num <= max; i++) res[i][right] = num++;
            right--;
            for (int j = right; j >= left && num <= max; j--) res[bottom][j] = num++;
            bottom--;
            for (int i = bottom; i >= top && num <= max; i--) res[i][left] = num++;
            left++;
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 3;
        Solution s = new Solution();
        int[][] m = s.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(m[i][j] + " ");
            System.out.println();
        }
    }
}
