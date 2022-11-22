class Solution {
    int dp[][];
    public int numSquares(int n) {
        List<Integer> arr = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            arr.add(i*i);
        }
        int size = arr.size();
        dp = new int[size+1][n+1];
        for(int i=0;i<=size;i++){
            Arrays.fill(dp[i], -1);
        }
        return util(arr, size, n);
    }
    
    public int util(List<Integer> arr, int n, int target){
        if(n==0 && target > 0)
            return Integer.MAX_VALUE;
        if(target <=0)
            return 0;
        int result =Integer.MAX_VALUE;
        if(dp[n][target] != -1)
            return dp[n][target];
        if(arr.get(n-1) <=target){
            int with = util(arr, n, target- arr.get(n-1));
            int without = util(arr, n-1, target);
            if(with != Integer.MAX_VALUE)
                with = 1+with;
            result = Math.min(with, without);
        }
        else{
            result = util(arr, n-1, target);
        }
        dp[n][target] =result;
        return result;
    }
    
}