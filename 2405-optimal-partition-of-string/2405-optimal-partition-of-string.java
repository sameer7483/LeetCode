class Solution {
    Map<String, Integer> m;
    public int partitionString(String s) {
        int res = 1;
        int bitmap = 0;
        for(int i=0;i<s.length();i++){
            if((bitmap & (1<<(s.charAt(i)-'a'))) > 0){
                res++;
                bitmap = 0;
            }
            bitmap = bitmap | (1<<(s.charAt(i)-'a'));
        } 
        return res;
    }
    
}