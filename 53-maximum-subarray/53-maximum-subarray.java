class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int maxHere = 0;
        for(int i=0;i<nums.length;i++){
            maxHere += nums[i];
            maxSum = Math.max(maxSum, maxHere);
            if(maxHere < 0){
                maxHere = 0;
            }
        }
        return maxSum;
    }
}