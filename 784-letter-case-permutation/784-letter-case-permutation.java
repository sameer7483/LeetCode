class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        util(s, 0, res);
        return res;
    }
    
    public void util(String s, int i, List<String> res){
        if(i == s.length()){
            res.add(s);
            return;
        }
        if(!Character.isDigit(s.charAt(i))){
            StringBuilder sb = new StringBuilder(s);
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                sb.setCharAt(i, Character.toLowerCase(ch));
            }
            else{
                sb.setCharAt(i, Character.toUpperCase(ch));
            }
            util(sb.toString(), i+1, res);
            util(s, i+1, res);
        }
        else{
            util(s, i+1, res);
        }
    }

}