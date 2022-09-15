class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2 != 0)
            return new int[0];
        int[] res = new int[n/2];
        int i=0;
        Map<Integer, Integer> m = new TreeMap<>();
        for(i=0;i<n;i++){
            m.put(changed[i], m.getOrDefault(changed[i], 0)+1);
        }
        i=0;
        for(int x : m.keySet()){
            if(m.get(x) > m.getOrDefault(2*x, 0))
                return new int[0];
            for(int j=0;j<m.get(x);j++){
                res[i++] = x;
                m.put(2*x, m.get(2*x)-1);
            }
        }
        return res;
        
    }
}