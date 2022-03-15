class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> set  = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                st.push(i);
            else if(s.charAt(i) == ')'){
                if(!st.isEmpty())
                    st.pop();
                else
                    set.add(i);
            }
        }
        while(!st.isEmpty()){
            set.add(st.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
        
    }
}