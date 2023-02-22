class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        if(n==0)
            return 0;
        int curr = 1;
        int res = 1;
        for(int i=1;i<n;i++){
            if(nums[i] == nums[i-1]+1){
                curr += 1;
            }
            else if(nums[i]==nums[i-1])
                continue;
            else{
                curr = 1;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}