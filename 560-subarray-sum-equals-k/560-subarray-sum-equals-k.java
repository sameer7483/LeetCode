class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int sum = 0;
        int res = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(m.containsKey(sum-k)){
                res += m.get(sum-k);
            }
            int count = m.getOrDefault(sum, 0);
            m.put(sum , count+1);
        }
        return res;
    }
}