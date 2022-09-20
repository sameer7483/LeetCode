class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max, piles[i]);
        }
        int lo = 1;
        int hi = max;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            int sum = 0;
            for(int i=0;i<piles.length;i++){
                sum += Math.ceil(piles[i]/(double)mid); 
            }
            if(sum > h){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
}