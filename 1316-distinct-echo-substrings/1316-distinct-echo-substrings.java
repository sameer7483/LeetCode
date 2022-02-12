class Solution {
    public int distinctEchoSubstrings(String s) {
        int n = s.length();
        int count = 0;
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j+1+j-i+1<=n;j++){
                String str = s.substring(i, j+1);
                if(s.substring(i, j+1).equals(s.substring(j+1, j+1+j-i+1))){
                    if(!set.contains(str)){
                        count++;
                        set.add(str);
                    }
                        
                }
                    

            }
        }
        return count;
    }
}