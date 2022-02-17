class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        double val = myPow(x, n/2) ;
        if(n % 2 == 0){
            return val * val;
        }
        else{
            if(n<0)
                return 1/x*val*val;            
            return x * val * val;
        }
    }
}