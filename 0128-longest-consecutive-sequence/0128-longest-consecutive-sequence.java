class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums)
            s.add(n);
        int res = 0;
        int i=0;
        while(i < nums.length){
            int y = nums[i];
            if(!s.contains(y-1)){
                while(s.contains(++y));
                res = Math.max(res, y-nums[i]);
            }
            i++;  
        }
        return res;
    }
}