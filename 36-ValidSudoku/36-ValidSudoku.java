// Last updated: 8/27/2025, 12:54:39 PM
import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use sets to track numbers in rows, columns, and boxes
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // Encode each rule as a unique string and check for duplicates
                    if (!seen.add(num + " in row " + i) ||
                        !seen.add(num + " in column " + j) ||
                        !seen.add(num + " in box " + (i / 3) + "-" + (j / 3))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
