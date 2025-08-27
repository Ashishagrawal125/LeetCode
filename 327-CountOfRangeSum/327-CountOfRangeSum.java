// Last updated: 8/27/2025, 12:53:14 PM
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private int mergeSort(long[] sums, int left, int right, int lower, int upper) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int count = mergeSort(sums, left, mid, lower, upper) + mergeSort(sums, mid + 1, right, lower, upper);

        int j = mid + 1, k = mid + 1, t = mid + 1;
        long[] temp = new long[right - left + 1];
        int r = 0;

        for (int i = left; i <= mid; i++) {
            while (k <= right && sums[k] - sums[i] < lower) k++;
            while (j <= right && sums[j] - sums[i] <= upper) j++;
            while (t <= right && sums[t] < sums[i]) temp[r++] = sums[t++];
            temp[r++] = sums[i];
            count += j - k;
        }
        while (t <= right) temp[r++] = sums[t++];
        System.arraycopy(temp, 0, sums, left, r);
        return count;
    }
}
