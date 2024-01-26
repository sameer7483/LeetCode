class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int prefix = 0;
        int res = 0;
        for(int num :  nums){
            prefix += num;
            if(m.containsKey(prefix-k)){
                res += m.get(prefix-k);
            }
            m.put(prefix, m.getOrDefault(prefix, 0)+1);
        }
        return res;
    }
}