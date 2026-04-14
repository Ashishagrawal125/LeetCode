// Last updated: 4/14/2026, 4:42:40 PM
class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int minR = m, maxR = -1, minC = n, maxC = -1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }
        if(maxR == -1) return 0;
        return (maxR - minR + 1) * (maxC - minC + 1);
    }
}
