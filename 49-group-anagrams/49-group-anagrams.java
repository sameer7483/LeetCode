class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            List<String> l = m.getOrDefault(s, new ArrayList<>());
            l.add(strs[i]);
            m.put(s, l);
        }
        return m.values().stream().collect(Collectors.toList());
    }
}