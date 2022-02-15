class Solution {
    public int maxProduct(int[] nums) {
        int maxPos = nums[0];
        int maxNeg = maxPos;
        int res = maxPos;
        for(int i=1;i<nums.length;i++){
            int temp = maxPos;
            maxPos = Math.max(maxPos * nums[i],Math.max(maxNeg * nums[i], nums[i]));
            maxNeg = Math.min(temp * nums[i],Math.min(maxNeg * nums[i], nums[i]));
            res = Math.max(res, maxPos);  
        }
        return res;
    }
}