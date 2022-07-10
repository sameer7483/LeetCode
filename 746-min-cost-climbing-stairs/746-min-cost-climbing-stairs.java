class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int sec = cost[1];
        if(n <= 2)
            return Math.min(first, sec);
        for(int i=2;i<n;i++){
            int curr = cost[i] + Math.min(first, sec);
            first = sec;
            sec = curr;
        }
        return Math.min(first, sec);      
    }
}