class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int i=0;
        int j = 0;
        long res = 0;
        while(j < nums.length){
            if(nums[j] != 0){
                j++;
                i = j;
                continue;
            }
            res += j-i+1;
            j++;
        }
        return res;
    }
}