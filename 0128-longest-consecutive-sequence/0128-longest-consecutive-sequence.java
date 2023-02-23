class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n :nums){
            s.add(n);
        }
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(!s.contains(nums[i]-1)){
                int y = nums[i];
                while(s.contains(y)) y++;
                res = Math.max(res, y-nums[i]);
            }
        }
        return res;
    }
}