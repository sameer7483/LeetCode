class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        for(int num : nums){
            s.add(num);
        }
        int res = 0;
        for(int num : nums){
            if(!s.contains(num-1)){
                int y = num+1;
                while(s.contains(y)){
                    y++;
                }
                res = Math.max(res, y-num);
            }
        }
        return res;
    }
    
}