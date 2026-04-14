// Last updated: 4/14/2026, 4:43:10 PM
class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int i = 0;
        while (i < n && directions.charAt(i) == 'L') i++;
        int j = n - 1;
        while (j >= 0 && directions.charAt(j) == 'R') j--;
        if (i > j) return 0;
        int ans = 0;
        for (int k = i; k <= j; k++) if (directions.charAt(k) != 'S') ans++;
        return ans;
    }
}
