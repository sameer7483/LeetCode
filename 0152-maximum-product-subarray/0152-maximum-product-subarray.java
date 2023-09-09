class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = max;
            max = Math.max(max*nums[i], Math.max(min*nums[i], nums[i]));
            min = Math.min(min*nums[i], Math.min(temp*nums[i], nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}