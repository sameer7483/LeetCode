class Solution {
    int res;
    public int findTargetSumWays(int[] nums, int target) {
        res = 0;
        util(nums, 0, 0, target);
        return res;
    }
    
    public void util(int[] nums,int start, int curr, int target){
        if(start == nums.length && curr == target)
            res++;
        if(start == nums.length)
            return;
        util(nums, start+1, curr + nums[start], target);
        util(nums, start+1, curr-nums[start], target);
    }
    
}