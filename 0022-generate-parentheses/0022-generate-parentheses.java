class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        util(n, 0, 0, "", res);
        return res;
    }
    
    public void util(int n, int op, int cl,String path, List<String> res){
        if(cl >= n){
            res.add(path);
            return;
        }
        if(op < n)
            util(n, op+1, cl, path+"(", res);
        if(op > cl){
           util(n, op, cl+1, path+")", res); 
        }
    }
}