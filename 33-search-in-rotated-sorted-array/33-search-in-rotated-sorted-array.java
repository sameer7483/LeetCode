class Solution {
    
    public int search(int[] nums, int target) {
        int idx = pivot(nums);
        int left = bs(nums, 0, idx-1, target);
        if(left != -1)
            return left;
        return bs(nums, idx, nums.length-1, target);
    }
    
    public int bs(int[] nums, int i, int j, int key){
        int lo = i;
        int hi = j;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == key)
                return mid;
            else if(nums[mid] < key){
                lo = mid+1;
            }
            else 
                hi = mid;
        }
        return nums[lo] == key ? lo : -1;
    }
    
    public int pivot(int[] nums){
        int lo =0;
        int hi = nums.length-1;
        while(lo < hi){
            int mid = hi - (hi-lo)/2;
            if(nums[mid] < nums[mid-1])
                return mid;
            else if(nums[mid] > nums[0]){
                lo = mid;
            }
            else if(nums[mid] < nums[0]){
                hi = mid-1;
            }
        }
        return lo;
    }
}