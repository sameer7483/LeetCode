class Solution {
    public boolean isPredecessor(String word1, String word2){
        if(word1.length()+1 != word2.length())
            return false;
        int i=0;
        int j = 0;
        while(i < word1.length() && j < word2.length()){
            if(word1.charAt(i) == word2.charAt(j))
                i++;
            j++;
        }
        return i==word1.length();
    }
    public int longestStrChain(String[] words) {
        //lc[i] = max(lc[j]) where words[j] is predecessor of words[i]
        int n = words.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1);
        int res = 1;
        Arrays.sort(words, (a, b)-> a.length() - b.length());
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPredecessor(words[j], words[i])){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}