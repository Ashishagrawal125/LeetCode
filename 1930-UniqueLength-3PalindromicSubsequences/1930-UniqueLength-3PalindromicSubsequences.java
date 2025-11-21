// Last updated: 11/21/2025, 11:45:03 PM
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        char[] a = s.toCharArray();

        for (int i = 0; i < n; ++i) {
            int idx = a[i] - 'a';
            if (first[idx] == -1) first[idx] = i;
            last[idx] = i;
        }

        int ans = 0;
        for (int c = 0; c < 26; ++c) {
            int L = first[c], R = last[c];
            if (L == -1 || L >= R) continue;
            boolean[] seen = new boolean[26];
            for (int i = L + 1; i < R; ++i) {
                seen[a[i] - 'a'] = true;
            }
            for (int m = 0; m < 26; ++m) if (seen[m]) ans++;
        }
        return ans;
    }
}
