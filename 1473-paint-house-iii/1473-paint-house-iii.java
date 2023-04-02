class Solution {
    int[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new int[m][n+1][target+1];
        int res = util(houses, cost, m, n, 0, 0, target);
        return res >= Integer.MAX_VALUE/2 ? -1 : res;
        
    }
    
    public int util(int[] houses, int[][] cost, int m, int n,int curr, int prev, int target){
        if(curr == houses.length || target < 0){
            if(target == 0)
                return 0;
            else
                return Integer.MAX_VALUE/2;
        }
        if(prev != -1 && dp[curr][prev][target] != 0)
            return dp[curr][prev][target];
        int res = Integer.MAX_VALUE;
        if(houses[curr] == 0){
            for(int i=1;i<=n;i++){
                res = Math.min(res, cost[curr][i-1]+util(houses, cost, m, n, curr+1, i, target - (i == prev ? 0 : 1)));
            }
            return dp[curr][prev][target] = res;
        }
        else{
            
            return dp[curr][prev][target] = util(houses, cost, m, n, curr+1, houses[curr], target - (houses[curr] == prev ? 0 : 1));
        }
    }
}