class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    backtrack(cand, path, res, target,0);
    return res;
    
    }
    
    public void backtrack(int[] nums, List<Integer> path, List<List<Integer>> res, int target, int start){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(target-nums[i] >=0){
                path.add(nums[i]);
                backtrack(nums, path, res, target-nums[i], i);
                path.remove(path.size()-1);
            }
        }
    }
    
    

}