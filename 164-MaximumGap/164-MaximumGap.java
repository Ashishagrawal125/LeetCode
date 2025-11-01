// Last updated: 11/1/2025, 10:47:48 PM
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int n = nums.length;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int v : nums) {
            if (v < minVal) minVal = v;
            if (v > maxVal) maxVal = v;
        }
        if (minVal == maxVal) return 0;
        int bucketSize = Math.max(1, (int)Math.ceil((double)(maxVal - minVal) / (n - 1)));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] bucketUsed = new boolean[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }
        for (int v : nums) {
            int idx = (v - minVal) / bucketSize;
            bucketUsed[idx] = true;
            if (v < bucketMin[idx]) bucketMin[idx] = v;
            if (v > bucketMax[idx]) bucketMax[idx] = v;
        }
        int prevMax = minVal;
        int maxGap = 0;
        boolean firstSeen = false;
        for (int i = 0; i < bucketCount; i++) {
            if (!bucketUsed[i]) continue;
            if (!firstSeen) {
                prevMax = bucketMax[i];
                firstSeen = true;
                continue;
            }
            int gap = bucketMin[i] - prevMax;
            if (gap > maxGap) maxGap = gap;
            prevMax = bucketMax[i];
        }
        return maxGap;
    }
}
