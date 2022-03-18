class Solution {
    
    public int climbStairs(int n) {
        if(n==1 || n==2)
            return n;
        int[] dp = new int[n+1];
        int lastSecond = 1;
        int last = 2;
        int curr = 0;
        for(int i=3;i<=n;i++){
            curr = last + lastSecond;
            lastSecond = last;
            last = curr;
        }
          
        return last;
    }
}