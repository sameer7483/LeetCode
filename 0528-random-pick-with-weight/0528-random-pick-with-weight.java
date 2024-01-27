class Solution {
    int[] wsum;
    Random rand;
    public Solution(int[] w) {
        int n = w.length;
        wsum = new int[n];
        rand = new Random();
        wsum[0] = w[0];
        for(int i=1;i<w.length;i++)
            wsum[i] += w[i] + wsum[i-1];
    }
    
    public int pickIndex() {
        
         int idx = rand.nextInt(wsum[wsum.length-1]);
         return bsNext(idx);
    }
    
    
    public int bsNext(int key){
        int lo = 0;
        int hi = wsum.length-1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(wsum[mid] <= key)
                lo = mid+1;
            else
                hi = mid;
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */