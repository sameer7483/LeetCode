class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0;i < s.length();i++){
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++){
            while(m.containsKey(order.charAt(i))){
                sb.append(order.charAt(i));
                m.put(order.charAt(i), m.getOrDefault(order.charAt(i), 0)-1);
                if(m.get(order.charAt(i)) == 0)
                    m.remove(order.charAt(i));
            }
        }
        for(Map.Entry<Character, Integer> ent : m.entrySet()){
            for(int i=0;i<ent.getValue();i++)
                sb.append(ent.getKey());
        }
        return sb.toString();
    }
}