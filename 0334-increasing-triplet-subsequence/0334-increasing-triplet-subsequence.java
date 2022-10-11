class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int smallest = Integer.MAX_VALUE;
        int bigger = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i] <= smallest){
                smallest = nums[i];
            }
            else if(nums[i] <= bigger){
                bigger = nums[i];
            }
            else return true;
        }
        return false;
    }
}