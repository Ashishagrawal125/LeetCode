// Last updated: 8/27/2025, 12:53:16 PM
class NumArray {
    private int[] bit;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        this.bit = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        for (int i = index + 1; i <= n; i += i & -i) {
            bit[i] += delta;
        }
    }

    private int query(int i) {
        int sum = 0;
        for (int idx = i; idx > 0; idx -= idx & -idx) {
            sum += bit[idx];
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}
