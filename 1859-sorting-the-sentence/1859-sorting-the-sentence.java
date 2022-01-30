class Solution {
    public String sortSentence(String s) {
        
        String[] str = s.split(" ");
        String[] res = new String[str.length];
        for(String a : str){
            String val = a.substring(0, a.length()-1);
            int idx = Integer.parseInt(a.substring(a.length()-1));
            res[idx-1] = val;
        }
        return String.join(" ", res);
    }
}