class Solution {
    public int maxSubArray(int[] nums) {
        //kadane
        int i=0, j=0;
        int sum =0;
        int max = Integer.MIN_VALUE;
        while(j<nums.length){
            sum += nums[j];
            max = Math.max(max, sum);
            if(sum < 0)
                sum =0;
            j++;
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