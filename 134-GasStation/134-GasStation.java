// Last updated: 8/27/2025, 12:53:42 PM
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }
        int idx = 0;
        int curr_fuel = 0;
        for (int i = 0; i < cost.length; i++) {
            curr_fuel += gas[i] - cost[i];
            if(curr_fuel < 0) {
                curr_fuel = 0;
                idx = i + 1;
            }
        }
        return idx;  
    }
}