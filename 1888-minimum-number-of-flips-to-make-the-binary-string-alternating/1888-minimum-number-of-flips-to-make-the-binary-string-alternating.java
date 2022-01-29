class Solution {
    public int minFlips(String s) {
        int t1=0, t2=0;
        s = s+s;
        int n = s.length();
        char[] alt1 = new char[n];
        char[] alt2 = new char[n];
        alt1[0] = '1';
        alt2[0] = '0';
        for(int i=1;i<n;i++){
            alt1[i] = alt2[i-1];
            alt2[i] = alt1[i-1];
        }        
        int i=0, j=0;
        int min = Integer.MAX_VALUE;
        while(j<n){
            if(s.charAt(j) != alt1[j])
                t1++;
            if(s.charAt(j) != alt2[j])
                t2++; 
            if(j-i+1<n/2)
                j++;
            else{
                min = Math.min(min, Math.min(t1, t2));
                if(s.charAt(i) != alt1[i])
                    t1--;
                if(s.charAt(i) != alt2[i])
                    t2--;
                i++;
                j++;
            }
        }
        
        return min;
    }
}