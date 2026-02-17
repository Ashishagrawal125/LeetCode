// Last updated: 2/17/2026, 1:17:57 PM
1import java.util.*;
2
3public class Solution {
4    public List<String> readBinaryWatch(int turnedOn) {
5        List<String> result = new ArrayList<>();
6        for (int h = 0; h < 12; h++) {
7            for (int m = 0; m < 60; m++) {
8                int bitsOn = Integer.bitCount(h) + Integer.bitCount(m);
9                if (bitsOn == turnedOn) {
10                    result.add(String.format("%d:%02d", h, m));
11                }
12            }
13        }
14        return result;
15    }
16}
17