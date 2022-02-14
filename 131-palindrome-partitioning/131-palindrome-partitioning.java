class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void backtrack(String s, int start, List<String> path, List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s, start, i+1)){
                path.add(s.substring(start, i+1));
                backtrack(s, i+1, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int i, int j){
        j=j-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
}