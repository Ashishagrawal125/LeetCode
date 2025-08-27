// Last updated: 8/27/2025, 12:53:35 PM
class Solution {
    public void rotate(int[] nums, int k) {
        Scanner input=new Scanner(System.in);
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
        
        
        
    }
    public static void reverse(int[] arr,int i ,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}