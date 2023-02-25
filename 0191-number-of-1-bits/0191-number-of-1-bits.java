public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int i=0;
        while(i < 32){
            res += n & 1;
            n = n >>> 1;
            i += 1;
        }
        return res;
    }
}