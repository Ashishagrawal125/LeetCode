// Last updated: 4/14/2026, 4:43:12 PM
class Solution {
    public int numberOfWays(String corridor) {
        long mod = 1000000007;
        int seats = 0;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') seats++;
        }
        if (seats == 0 || seats % 2 == 1) return 0;

        long ways = 1;
        int countS = 0;
        int plants = 0;

        for (int i = 0; i < corridor.length(); i++) {
            char c = corridor.charAt(i);
            if (c == 'S') {
                countS++;
                if (countS > 2 && countS % 2 == 1) {
                    ways = (ways * (plants + 1)) % mod;
                }
                plants = 0;
            } else if (countS >= 2 && countS % 2 == 0) {
                plants++;
            }
        }
        return (int) ways;
    }
}
