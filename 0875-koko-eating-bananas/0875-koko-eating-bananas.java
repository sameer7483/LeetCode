class Solution {
    
    public int time(int[] piles, int k){
        int t = 0;
        for(int p : piles){
            t += Math.ceil(p/(double)k);
        }
        return t;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = Arrays.stream(piles).max().getAsInt();
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            int t = time(piles, mid);
            if(t > h){
                lo = mid+1;
            }
            else hi = mid;
        }
        return lo;
    }
}