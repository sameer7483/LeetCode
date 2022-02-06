class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        if(nums.length ==1)
            return 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]-nums[i+1] >=0){
                res+= nums[i]-nums[i+1] +1;
                nums[i+1] = nums[i] +1;
            }
        }
        return res;
    }
}