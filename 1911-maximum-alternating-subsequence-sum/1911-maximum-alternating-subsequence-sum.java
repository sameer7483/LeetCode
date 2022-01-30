class Solution {
    long dp[][];
    public long maxAlternatingSum(int[] nums) {
        dp = new long[nums.length][2];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i], -1);
        return util(nums, 0, 1);
    }
    
    public long util(int[] nums,int start, int even){
        if(start == nums.length)
            return 0;
        if(dp[start][even] != -1)
            return dp[start][even] ;
        long sum = even==1 ? nums[start] : -nums[start];
        return dp[start][even] = Math.max(sum+util(nums, start+1, even^1), util(nums, start+1,  even));
    }
}