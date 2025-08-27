// Last updated: 8/27/2025, 12:55:02 PM
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create a list of StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Track the current row and direction
        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the input string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction at the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to the next row
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
