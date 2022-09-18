class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        util("", n, 0, 0, res);
        return res;
    }
    
    public void util(String curr, int n, int open , int close, List<String> res){
        if(open == close && open == n){
            res.add(curr);
        }
        if(open < n){
            util(curr+"(", n, open+1, close, res);
        }
        if(close < open && close < n){
            util(curr+")", n, open, close+1, res);
        }
    }
}