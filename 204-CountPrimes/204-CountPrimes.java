// Last updated: 8/27/2025, 12:53:34 PM
class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        return PrimeSeive(n);
        }
        public static int PrimeSeive(int n) {
        int[] ans = new int[n];
        ans[0] = ans [1] = 1;
        for (int i = 2; i * i <= n; i++) {
            if(ans[i]==0){
                // i prime number hai
                for (int j = 2 ;i * j < ans.length; j++) {
                    ans[i * j] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < ans.length; i++) {
            if(ans[i]==0){
                count++;
            }
        }
        return count;
    }
}