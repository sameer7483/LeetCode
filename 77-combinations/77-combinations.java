class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=1;i<=n;i++)
            nums[i-1] = i;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, res, 0, path, k);
        return res;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> res,int start, List<Integer> path, int k){
    if(path.size() == k){
        res.add(new ArrayList<>(path));
        return;
    }
    for(int i=start;i<nums.length;i++){
        path.add(nums[i]);
        backtrack(nums, res, i+1, path, k);
        path.remove(path.size()-1);
    }        
    }

}