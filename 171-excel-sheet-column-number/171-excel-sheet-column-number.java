class Solution {
    public int titleToNumber(String c) {
        int res = 0;
        int n = c.length();
        for(int i=n-1;i>=0;i--){
            res += (int)Math.pow(26, n-1-i)*(c.charAt(i) -'A'+1);
        }
        return res;
    }
}