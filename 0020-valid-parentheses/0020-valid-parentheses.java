class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        List<Character> close = Arrays.asList(')', ']', '}');
        List<Character> open = Arrays.asList('(', '[', '{');
        for(int i=0;i<s.length();i++){
            if(st.isEmpty() && close.contains(s.charAt(i)))
                return false;
            if(st.isEmpty() || open.contains(s.charAt(i))){
                st.push(s.charAt(i));
            }
            else if(st.peek() == '[' && s.charAt(i) != ']')
                return false;
            else if(st.peek() == '{' && s.charAt(i) != '}')
                return false;  
            else if(st.peek() == '(' && s.charAt(i) != ')')
                return false;            
            else
                st.pop();
        }
        return st.isEmpty();
    }
}