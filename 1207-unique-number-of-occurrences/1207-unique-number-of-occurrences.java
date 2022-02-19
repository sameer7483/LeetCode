class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int a : arr){
            int c = m.getOrDefault(a, 0);
            m.put(a, c+1);
        }
        Set<Integer> s = new HashSet<>();
        for(Map.Entry<Integer, Integer> ent : m.entrySet()){
            if(s.contains(ent.getValue()))
                return false;
            s.add(ent.getValue());
        }
        return true;
    }
}