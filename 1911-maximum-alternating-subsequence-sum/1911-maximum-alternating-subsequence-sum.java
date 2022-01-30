class Solution {
    long dp[][];
    public long maxAlternatingSum(int[] nums) {
        long odd = 0, even = 0;
        for (int a: nums) {
            long temp = even;
            even = Math.max(even, odd + a);
            odd = Math.max(odd, temp - a);
        }
        return Math.max(odd, even);
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