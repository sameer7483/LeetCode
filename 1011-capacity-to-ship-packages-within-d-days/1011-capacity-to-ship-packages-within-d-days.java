class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        for(int w : weights){
            lo = Math.max(w, lo);
            hi += w;
        }
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            int curr = 0;
            int need = 1;
            for(int w : weights){
                curr += w;
                if(curr > mid){
                    curr = w;
                    need += 1;
                }
            }
            if(need > days){
                lo = mid+1;
            }
            else
                hi = mid;
        }
        return lo;
    }
}