// Last updated: 2/25/2026, 4:21:05 PM
1class Solution {
2    public int[] sortByBits(int[] arr) {
3        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
4        Comparator<Integer> comparator = new CustomComparator();
5        Arrays.sort(nums, comparator);
6        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
7    }
8}
9
10class CustomComparator implements Comparator<Integer> {
11    @Override
12    public int compare(Integer a, Integer b) {
13        if (Integer.bitCount(a) == Integer.bitCount(b)) {
14            return a - b;
15        }
16        
17        return Integer.bitCount(a) - Integer.bitCount(b);
18    }
19}