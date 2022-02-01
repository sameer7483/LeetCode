class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1)
            return x;
        int lo = 1;
        int hi = x/2;
        
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;
            long mul =(long) mid * mid;
            if(mul < x)
                lo = mid+1;
            else if(mul > x)
                hi = mid-1;

            else
                return mid;
        }
        return hi;
    }
}