class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1, -1}; 
        int lo =0, hi = nums.length-1;
        int first=-1; int last = -1;
        int[] res = new int[2];
        while(lo < hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid] < target)
                lo = mid+1;
            else
                hi = mid;
        }
        if(nums[lo] != target) return new int[]{-1, -1};
        first = lo;
        hi = nums.length-1;
        while(lo < hi){
            int mid = hi-(hi-lo)/2;
            if(nums[mid] <= target)
                lo = mid;
            else
                hi = mid-1;
        } 
        last = lo;
        return new int[]{first, last};
        
    }
}