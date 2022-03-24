class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for(int i=0;i<time.length;i++){
            int mod = (540-time[i])%60;
            if(m.containsKey(mod)){
                res += m.get(mod);
            }
            int c = m.getOrDefault(time[i]%60,0);
            m.put(time[i]%60, c+1);
        }
        return res;
    }
}