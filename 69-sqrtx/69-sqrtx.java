class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1)
            return x;
        int lo = 1;
        int hi = x/2;
        
        while(lo <= hi){
             int mid = hi -(hi-lo)/2;
            long multiply =(long) mid * mid;
            if(multiply == x)
                return mid;
            else if( multiply > x)
            {
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return hi;
    }
}