class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
            sb.append("a");
        k = k-n;
        int j= n-1;
        while(k >= 25){
            sb.setCharAt(j, 'z');
            j--;
            k = k-25;
        }
        if(k>0)
            sb.setCharAt(j, (char)(97+k));
        return sb.toString();
        
    }
    
    public String util(int n, int k, int curr, String s){
        if(n==0 && curr == k){
            return s;
        }
        if(n < 0)
            return "";
        for(int i=0;i<26;i++){
            String with = util(n-1, k, curr+i+1, s+(char)(i+97));
            if(!with.isEmpty())
                return with;
            String without = util(n-1, k, curr, s);
            if(!without.isEmpty())
                return without;
        }
        return "";
    }
}