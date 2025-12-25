// Last updated: 12/25/2025, 9:55:17 PM
1class Solution {
2    public long maximumHappinessSum(int[] happiness, int k) {
3        int happinessSize = happiness.length;
4        
5        // Convert the array to an Integer array for sorting in descending order
6        Integer[] happinessArray = new Integer[happinessSize];
7        for(int i = 0; i < happinessSize; i++) {
8            happinessArray[i] = happiness[i];
9        }
10        
11        Arrays.sort(happinessArray, Collections.reverseOrder());
12
13        long totalHappinessSum = 0;
14        int turns = 0;
15        
16        // Calculate the maximum happiness sum
17        for(int i = 0; i < k; i++) {
18            // Adjust happiness and ensure it's not negative
19            totalHappinessSum += Math.max(happinessArray[i] - turns, 0);  
20
21             // Increment turns for the next iteration
22            turns++; 
23        }
24        
25        return totalHappinessSum;
26    }
27}