class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        util(s, dict, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void util(String s, Set<String> dict, int curr, List<String> path, List<String> res){
        if(curr == s.length()){
            res.add(String.join(" ", path));
        }
        for(int i=curr;i<s.length();i++){
            if(dict.contains(s.substring(curr, i+1))){
                path.add(s.substring(curr, i+1));
                util(s, dict, i+1, path, res);
                path.remove(path.size()-1);
            }
        }
    }
}