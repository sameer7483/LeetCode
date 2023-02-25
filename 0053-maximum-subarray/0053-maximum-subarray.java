class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curr = 0;
        for(int num : nums){
            curr += num;
            res = Math.max(res, curr);
            if(curr < 0){
                curr = 0;
            }
        }
        return res;
    }
}