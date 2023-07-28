class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid+1] > nums[mid])
                lo = mid+1;
            else
                hi = mid;      
        }
        return lo;
    }
}