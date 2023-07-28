class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] >= nums[0]){
                if((target < nums[mid] && target < nums[0]) || (target > nums[mid] && target > nums[0]))
                    lo = mid + 1;
                else
                    hi = mid;
            }
            else{
                if((target > nums[mid] && target < nums[0]))
                    lo = mid + 1;
                else 
                    hi = mid;                
            }      
        }
        return nums[lo] == target ? lo : -1;
    }
}