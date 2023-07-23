class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Long, Integer> m = new HashMap<>();
        m.put(0L, 1);
        long sum = 0;
        int res = 0;
        for(int num : nums){
            sum += num;
            if(m.containsKey(sum-k)){
                res += m.get(sum-k);
            }
            m.put(sum, m.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}