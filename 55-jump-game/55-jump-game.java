class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reach = nums[0];
        for(int i=1;i<n && i <= reach;i++){
            reach = Math.max(i+nums[i], reach);
        }
        return reach >= n-1;
    }
}