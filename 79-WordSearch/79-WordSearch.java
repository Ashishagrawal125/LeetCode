// Last updated: 8/27/2025, 12:54:08 PM
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        // Iterate through every cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start a DFS search from each cell
                if (dfs(board, word, i, j, 0)) {
                    return true;  // Found the word
                }
            }
        }

        return false;  // Word not found in the grid
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // If the index is equal to the length of the word, we have found the word
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and if the current cell matches the character in the word
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited by changing the character
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all four directions (up, down, left, right)
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        // Backtrack by restoring the cell value
        board[i][j] = temp;

        return found;
    }
}
