class Solution {
    public boolean isValid(String s) {
        List<Character> ch = Arrays.asList('(', '{', '[');
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(ch.contains(s.charAt(i)))
                st.push(s.charAt(i));
            else if(s.charAt(i) == '}' && !st.isEmpty() && st.peek() != '{')
                return false;
            else if(s.charAt(i) == ')' && !st.isEmpty() && st.peek() != '(')
                return false;
            else if(s.charAt(i) == ']' && !st.isEmpty() && st.peek() != '[')
                return false;
            else if(st.isEmpty())
                return false;
            else
                st.pop();  
        }
        return st.isEmpty();
    }
}