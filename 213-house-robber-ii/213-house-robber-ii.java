class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1)
            return nums[0];
        return Math.max(util(nums, 0, n-2), util(nums,1, n-1));
    }
    
    
    public int util(int[] nums,int start, int end){
        int last = 0, lastSecond = 0;
        for(int i=start;i<=end;i++){
            int curr = Math.max(last, lastSecond+nums[i]);
            lastSecond = last;
            last = curr;
        }
        return last;
    }
}