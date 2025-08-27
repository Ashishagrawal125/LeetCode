// Last updated: 8/27/2025, 12:53:46 PM
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans =0;
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int i = 0; i< nums.length; i++){
            if(! set.contains(nums[i]-1)){
                int c = 0;
                int key = nums[i];
                while(set.contains(key)){
                    set.remove(key);
                    c++;
                    key++;
                }
                ans= Math.max(ans, c);
            }
        }
        return ans;
    }
}