class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int res = 1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j] < nums[i]){
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                }
            }
            res = Math.max(res, lis[i]);
        }
        return res;
    }
}