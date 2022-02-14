class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        util(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void util(int[] nums, int start, List<Integer> path, List<List<Integer>> res){
        res.add(new ArrayList<>(path));
        for(int i=start;i<nums.length;i++){
            if(i != start && nums[i]== nums[i-1]) continue;
            path.add(nums[i]);
            util(nums, i+1, path, res);
            path.remove(path.size()-1);
        }
    }
}