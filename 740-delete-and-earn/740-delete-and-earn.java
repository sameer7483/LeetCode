class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[20001];
        for(int num :nums){
            count[num] += num;
        }
        int[] dp = new int[20001];
        dp[0] = 0;
        dp[1] = count[0];
        for(int i=2;i<20001;i++){
            dp[i] = Math.max(count[i-1]+dp[i-2], dp[i-1]);
        }
        return dp[20000];
    }
}