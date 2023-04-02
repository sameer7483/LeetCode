class Solution {
    public int[] successfulPairs(int[] sp, int[] pot, long succ) {
        Arrays.sort(pot);
        int[] res = new int[sp.length];
        for(int i=0;i<sp.length;i++){
            res[i] = bs(pot, sp[i], succ);
        }
        return res;
    }
    
    public int bs(int[] pot,int num, long succ){
       //first greater than equal to succ
        int lo = 0;
        int hi = pot.length-1;
        int res = pot.length;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            long key = (long)num * pot[mid];
            if(key >= succ){
                res = mid;
                hi = mid-1;
            }
            else
                lo = mid+1;
        }
        return pot.length-res;
    }
}