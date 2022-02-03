class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++)
            map.put(order.charAt(i), i);
        for(int i=0;i<words.length-1;i++){
            int m = words[i].length();
            int n = words[i+1].length();
            for(int j=0;j<m;j++){
                if(j==n)
                    return false;
                if(words[i].charAt(j) != words[i+1].charAt(j)){
                    if(map.get(words[i].charAt(j)) > map.get(words[i+1].charAt(j)))
                    return false;
                    break;
                }
                
            }
        }
        return true;
    }
}