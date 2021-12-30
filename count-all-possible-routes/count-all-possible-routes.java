class Solution {
    long dp[][];
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        dp = new long[n+1][fuel+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i], -1);
        return util(locations, start, finish, fuel);
    }
    
    public int util(int[] locations, int start, int finish, int fuel){
        if(fuel <0)
            return 0;
        if(dp[start][fuel]!=-1)
            return (int)(dp[start][fuel]% (int)(1e9+7));
         int n = locations.length;
        int ans=0;
        if(start == finish){
            ans= 1;
        }
       
        long sum = 0;
        for(int i=0;i<n;i++){
            if(i != start){
                sum +=  util(locations, i, finish, fuel-Math.abs(locations[start]- locations[i]));
            }
        }
        dp[start][fuel]=(long)(ans+ sum % (int)(1e9+7));
        return (int)dp[start][fuel];
    }
}