class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] globalCounter = new int[26];
        for(String word : words2){
            int[] count = new int[26];
            for(int i=0;i<word.length();i++){
                count[word.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++){
                globalCounter[i] = Math.max(globalCounter[i], count[i]);
            }
        }
        
        for(String word : words1){
            int[] count = new int[26];
            for(int i=0;i<word.length();i++){
                count[word.charAt(i)-'a']++;
            }
            int j=0;
            while(j < 26){
                if(globalCounter[j] > count[j])
                    break;
                j++;
            }
            if(j==26)
                res.add(word);
        }
        return res;
            
    }
}