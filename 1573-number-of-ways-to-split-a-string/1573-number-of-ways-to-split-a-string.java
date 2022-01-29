class Solution {
    public int numWays(String s) {
        long n = s.length();
        long mod = (long)1e9+7;
        long ones =0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')
                ones++;
        }
        if(ones%3!=0)
            return 0;
        if(ones == 0)
            return (int) ((((n-1)*(n-2))/2)%mod);
        long each = ones/3;
        long firstCut =0;
        long secondCut =0;
        long count =0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')
                count++;
            if(count==each) 
                firstCut++;
            else if(count==2*each)
                secondCut++;
        }
        return (int)((firstCut*secondCut)%mod);
    }
}