class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for(int i=0;i<letters.length;i++){
            count[letters[i]-'a']++;
        }
        return util(words, score, 0, count);
    }
    
    public int util(String[] words, int[] score, int start, int[] count){
        if(start >= words.length)
            return 0;
        int i=0;
        for(i=0;i<26;i++){
            if(count[i] > 0)
                break;
        }
        if(i == 26)
            return 0;
        String curr = words[start];
        int with = 0;
        boolean made = true;
        int j=0;
        for(j=0;j<curr.length();j++){
            if(count[curr.charAt(j)-'a']-- <= 0){
                made = false;
                break;
            }
        }
        int currScore = 0;
        if(made){//can be made
            for(i=0;i<curr.length();i++){
                currScore += score[curr.charAt(i)-'a'];
            }
            with = currScore + util(words, score, start+1, count);     
            j=j-1;
        } 
        for(;j>=0;j--)
            count[curr.charAt(j)-'a']++;
        int without = util(words, score, start+1, count);       
        return Math.max(with, without);
        
    }
}