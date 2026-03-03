// Last updated: 3/3/2026, 5:07:05 PM
1class Solution {
2
3    public char findKthBit(int n, int k) {
4        StringBuilder sequence = new StringBuilder("0");
5
6        // Generate sequence until we have enough elements or reach nth iteration
7        for (int i = 1; i < n && k > sequence.length(); ++i) {
8            sequence.append('1');
9
10            // Append the inverted and reversed part of the existing sequence
11            for (int j = sequence.length() - 2; j >= 0; --j) {
12                char invertedBit = (sequence.charAt(j) == '1') ? '0' : '1';
13                sequence.append(invertedBit);
14            }
15        }
16
17        // Return the kth bit
18        return sequence.charAt(k - 1);
19    }
20}