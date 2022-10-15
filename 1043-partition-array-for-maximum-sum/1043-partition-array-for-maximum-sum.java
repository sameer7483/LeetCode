class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return util(arr, 0, k);
    }
    
    public int util(int[] arr, int start, int k){
        if(start >= arr.length)
            return 0;
        if(dp[start] != -1)
            return dp[start];
        int max = 0;
        int res = 0;
        for(int i=start;i<start+k && i < arr.length;i++){
            max = Math.max(max, arr[i]);
            int cal = (i-start+1)*max+util(arr, i+1, k);
            res = Math.max(res, cal);
        }
        return dp[start]=res;
    }
}