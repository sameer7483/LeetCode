class Solution {
    Map<Integer, Integer> dp;
    public int minDays(int n) {
        dp = new HashMap<>();
        return dpUtil(n);
    }
    
    public int dpUtil(int n){
        if(n==1 || n==0)
            return n;
        if(dp.containsKey(n))
            return dp.get(n);
        int one = 1 + (n%2) + dpUtil(n/2);
        int two = 1 + (n%3) + dpUtil(n/3);
        dp.put(n, Math.min(one, two));
        return dp.get(n);
    }
}