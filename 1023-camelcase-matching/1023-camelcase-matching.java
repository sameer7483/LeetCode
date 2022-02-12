class Solution {
    public List<Boolean> camelMatch(String[] queries, String p) {
        List<Boolean> res = new ArrayList<>();
    
        for(String str : queries){
            int i=0, j=0;
            while(i< str.length()){
                if(j< p.length() && p.charAt(j)==str.charAt(i)){
                    i++;
                    j++;
                }
                else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    break;
                }
                else
                    i++;
                    
            }
            if(i==str.length() && j==p.length())
                res.add(true);
            else res.add(false);
                
        }
        return res;
        
    }
}