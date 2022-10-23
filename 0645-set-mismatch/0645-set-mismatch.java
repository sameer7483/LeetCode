class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1] < 0){
                res[idx++] = Math.abs(nums[i]);
            }
            else{
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                res[idx++] = i+1;
        }

        return res;
        
    }
}