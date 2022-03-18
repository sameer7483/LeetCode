class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        int[] seen = new int[26];
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a'] = i;
        }
        st.push(s.charAt(0));
        seen[s.charAt(0)-'a']=1;
        for(int i=1;i<s.length();i++){
            while(!st.isEmpty() && st.peek() > s.charAt(i) && seen[s.charAt(i)-'a'] ==0 && last[st.peek()-'a'] > i){
                seen[st.peek()-'a'] = 0;
                st.pop();
            }
            if(seen[s.charAt(i)-'a'] == 0){
                st.push(s.charAt(i));
                seen[s.charAt(i)-'a']=1;
            }       
        }
        String res = "";
        while(!st.isEmpty()){
            res = st.pop()+res;
        }
        return res;
    }
}