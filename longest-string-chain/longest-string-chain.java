class Check{
    String s1;
    String s2;
    public Check(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
    }
}

class Solution {
    int[] dp;
    Map<Check,Integer> map;
    public int longestStrChain(String[] words) {
        int n = words.length;
        map = new HashMap<>();
        dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        int max = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            dp[i] = 1;
            for(int j=0;j<words[i].length();j++){
                String str = words[i].substring(0,j)+ words[i].substring(j+1, words[i].length());
//                System.out.println(str);
                int val = map.getOrDefault(str, 0);    
                dp[i] = Math.max(dp[i], 1+val);
            }
            map.put(words[i], dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    

    
}