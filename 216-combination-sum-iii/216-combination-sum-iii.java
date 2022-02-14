class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[9];
        for(int i=1;i<=9;i++){
            nums[i-1] = i;
        }
        backtrack(nums, 0, new ArrayList<>(), res, n, k);
        return res;
    }
    
    public void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res, int target, int k){
        if(target==0 && path.size()==k){
            res.add(new ArrayList<>(path));
            return ;
        }
        if(target ==0)
            return;
        for(int i=start;i<nums.length;i++){
            if(target-nums[i] >= 0){
                path.add(nums[i]);
                backtrack(nums, i+1, path, res, target-nums[i], k);
                path.remove(path.size()-1);
            }
        }
    }
    
}