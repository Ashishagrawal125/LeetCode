// Last updated: 10/3/2025, 11:32:19 PM
class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] arr = new int[n + 2];
        arr[0] = 1; arr[1] = 2; arr[2] = 2;

        int head = 2, tail = 3, num = 1, count = 1;

        while (tail < n) {
            for (int i = 0; i < arr[head]; i++) {
                arr[tail] = num;
                if (num == 1 && tail < n) count++;
                tail++;
            }
            num = num ^ 3; // toggles between 1 and 2
            head++;
        }
        return count;
    }
}
