class Solution {
    public int concatenatedBinary(int n) {
        int i=1;
        int mod = (int)(1e9+7);
        int res = 1;
        for(i=1;i<n;i++){
            int len = getLength(i+1);
            while(len > 0){
                res=(res<<1)%mod;
                len--;
            }
            res = (res+i+1)%mod;
        }
        
        return res;
    }
    
    public int getLength(int n){
        int len = 0;
        while(n > 0){
            n = n>>1;
            len++;
        }
        return len;
    }
}