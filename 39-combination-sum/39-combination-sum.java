class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        util(candidates, 0, target, new ArrayList<>(), res);
        return res;
        
    }
    
    public void util(int[] cand, int start, int target,List<Integer> path, List<List<Integer>> res){
        if(start==cand.length || target < 0)
            return;
        if(target == 0){
            
            res.add(new ArrayList<>(path));
            return;
        }
        if(target-cand[start] >= 0){
            path.add(cand[start]);
            util(cand, start, target-cand[start], path, res);
            path.remove(path.size()-1);
        }
            util(cand, start+1, target, path, res);
    }
}