class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Long, Integer> m = new HashMap<>();
        m.put(0L, -1);
        long sum = 0;
        if(nums.length < 2) return false;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            long mod = sum % k;
            if(!m.containsKey(mod))
                m.put(mod, i);
            else if(m.containsKey(mod) && (i-m.get(mod)) > 1)
                return true;
        }
        return false;
        
    }
}