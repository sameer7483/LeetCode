class Solution {
    public int maxSubArray(int[] nums) {
        //kadane
        int max = Integer.MIN_VALUE/2;
        int maxEndHere= 0;
        for(int i=0;i<nums.length;i++){
            maxEndHere += nums[i];
            max = Math.max(max, maxEndHere);
            if(maxEndHere < 0){
                maxEndHere = 0;
            }
        }
        return max;
        
    }
    
    
    // Divide and conquer
    public int util(int []nums, int lo, int hi){
        if(lo == hi)
            return nums[lo];
        int mid = lo+(hi-lo)/2;
        int left = util(nums, lo, mid);
        int right = util(nums, mid+1, hi);
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid;i>=lo;i--){
            sum += nums[i];
            if(sum > leftMax)
                leftMax = sum;
        }
        sum = 0;
        int rightMax = Integer.MIN_VALUE;
        for(int i=mid+1;i<=hi;i++){
            sum += nums[i];
            if(sum > rightMax)
                rightMax = sum;
        }
        
        return Math.max(leftMax+rightMax, Math.max(left, right));
    }
}