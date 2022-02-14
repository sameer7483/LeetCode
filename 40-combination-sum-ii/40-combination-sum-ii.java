class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(cand);
        backtrack(cand, 0, path, res, target);
        return res;
        
    }
    
    public void backtrack(int nums[], int start, List<Integer> path, List<List<Integer>> res, int target){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(i != start && nums[i]==nums[i-1]) continue;
            if(target-nums[i] >=0){
                path.add(nums[i]);
                backtrack(nums, i+1, path, res, target-nums[i]);
                path.remove(path.size()-1);
            }
        }
    }
    

}