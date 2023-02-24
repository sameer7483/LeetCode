class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = minProd;
            minProd = Math.min(maxProd*nums[i], Math.min(minProd*nums[i], nums[i]));
            maxProd = Math.max(temp*nums[i], Math.max(maxProd*nums[i], nums[i]));
            res = Math.max(res, maxProd);
        }
        return res;
    }
}