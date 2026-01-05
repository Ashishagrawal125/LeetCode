// Last updated: 1/5/2026, 9:48:13 PM
1class Solution {
2    public long maxMatrixSum(int[][] matrix) {
3        int n = matrix.length;
4        long totalSum = 0;
5        int negativeCount = 0;
6        int minAbsValue = Integer.MAX_VALUE;
7
8        for (int i = 0; i < n; i++) {
9            for (int j = 0; j < n; j++) {
10                int value = matrix[i][j];
11                totalSum += Math.abs(value);
12                if (value < 0) {
13                    negativeCount++;
14                }
15                minAbsValue = Math.min(minAbsValue, Math.abs(value));
16            }
17        }
18
19        if (negativeCount % 2 == 0) {
20            return totalSum;
21        } else {
22            return totalSum - 2 * minAbsValue;
23        }
24    }
25}