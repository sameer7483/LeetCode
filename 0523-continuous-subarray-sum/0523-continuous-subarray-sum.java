class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        long sum = 0;
        m.put(0, -1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int mod =(int) sum%k;
            if(!m.containsKey(mod)){
                m.put(mod, i);
            }
            else if(i-m.get(mod) > 1)
                return true;
        }
        return false;
    }
}