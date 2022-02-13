class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        util(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void util(int[] nums, int start, List<Integer> path, List<List<Integer>> res){
        res.add(new ArrayList<>(path));
        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            util(nums, i+1, path, res);
            path.remove(path.size()-1);
        }
        
    }
    
}