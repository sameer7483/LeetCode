class Solution {
    public int maxProduct(int[] nums) {
        int maxNeg = nums[0];
        int maxPos = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = maxPos;
            maxPos = Math.max(nums[i], Math.max(maxPos*nums[i], maxNeg*nums[i]));
            maxNeg = Math.min(nums[i], Math.min(temp*nums[i], maxNeg*nums[i]));
            res = Math.max(res, maxPos);
        }
        return res;
    }
}