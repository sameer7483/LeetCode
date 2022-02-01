class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(m.containsKey(s.charAt(i))){
                m.put(s.charAt(i), -1);
            }
            else{
                m.put(s.charAt(i), i);
            }
        }
        int min = s.length();
        for(Map.Entry<Character, Integer> entry : m.entrySet()){
            if(entry.getValue() >= 0){
                min = Math.min(min, entry.getValue());
            }
        }
        return min ==s.length() ? -1 : min;
    }
}