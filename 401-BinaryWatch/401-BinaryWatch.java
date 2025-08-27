// Last updated: 8/27/2025, 12:53:10 PM
import java.util.*;

public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                int bitsOn = Integer.bitCount(h) + Integer.bitCount(m);
                if (bitsOn == turnedOn) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }
}
