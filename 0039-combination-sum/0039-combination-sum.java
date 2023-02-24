class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        util(cand, 0, target, path, res);
        return res;
    }
    
    public void util(int[] cand,int start, int target, List<Integer> path, List<List<Integer>> res){
        if(start >= cand.length)
            return;
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<cand.length;i++){
            if(target-cand[i] >= 0){
                path.add(cand[i]);
                util(cand, i, target-cand[i], path, res);
                path.remove(path.size()-1);
            }
        }
    }
}