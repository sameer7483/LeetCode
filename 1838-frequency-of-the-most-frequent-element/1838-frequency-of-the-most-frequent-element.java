class Solution {
    public int maxFrequency(int[] nums, int k) {
        long sum = 0;
        int i=0, j=0;
        int n = nums.length;
        int ans =0;
        Arrays.sort(nums);
        while(j<n){
            sum += nums[j];
            if((j-i+1)*nums[j] <= sum+k)
                ans = Math.max(ans, j-i+1);
            else{
                while(i<=j && (j-i+1)*nums[j] > sum+k){
                 sum-=nums[i];
                 i++;                   
                }
                ans =  Math.max(ans, j-i+1);
            }
            j++;
        }
        return ans;
    }
}