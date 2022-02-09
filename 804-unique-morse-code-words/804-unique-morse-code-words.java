class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> s = new HashSet<>();
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<word.length();i++){
                sb.append(arr[word.charAt(i)-'a']);
            }
            s.add(sb.toString());
        }
        return s.size();
        
    }
}