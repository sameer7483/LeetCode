class Solution {
    Map<Integer, List<Integer>> m;
    public Solution(int[] nums) {
        m = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            List<Integer> l = m.getOrDefault(nums[i],new ArrayList<>());
            l.add(i);
            m.put(nums[i], l);
        }
    }
    
    public int pick(int target) {
        List<Integer> l = m.get(target);
        int n = l.size();
        Random rand = new Random();
        return l.get(rand.nextInt(n));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */