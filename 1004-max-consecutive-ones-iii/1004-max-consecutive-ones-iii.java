class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int count = 0;
        int res = 0;
        for(int j=0;j<nums.length;j++){
            count += nums[j];
            while(i < j && j-i+1 > count + k){
                count -= nums[i];
                i++;
            }
            if(k != 0 || count > 0)
                res = Math.max(res, j-i+1);  
        }
        return res;
    }
}