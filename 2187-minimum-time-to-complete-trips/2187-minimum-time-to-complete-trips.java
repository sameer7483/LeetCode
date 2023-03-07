class Solution {
    public long minimumTime(int[] time, int trip) {
        Arrays.sort(time);
        return bs(time, trip);
    }
    
    public long bs(int[] time, int trip){
        long lo = 1;
        long hi = time[0]*(long)trip;
        while(lo < hi){
            long mid = lo + (hi-lo)/2;
            long curr = util(time, mid);
            if(curr < trip){
                lo = mid+1;
            }
            else
                hi = mid;
        }
        return lo;
    }
    public long util(int[] time, long t){
        long trip = 0;
        for(int i=0;i<time.length;i++){
            trip += (t/time[i]);
        }
        return trip;
    }
}