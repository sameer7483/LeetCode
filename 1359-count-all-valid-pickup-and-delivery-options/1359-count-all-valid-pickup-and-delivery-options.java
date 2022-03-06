class Solution {
    public int countOrders(int n) {
        //n! * (1*3*5*..(2n-1))
        int mod = (int)(1e9+7);
        long res = 1;
        for(int i=1;i<=n;i++){
            res = (res*i) %mod;
            res = (res*(2*i-1))%mod;
        }
        return (int)res%mod;
    }
}