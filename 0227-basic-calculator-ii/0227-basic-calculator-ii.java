class Solution {
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        char prevOp = '+';
        s = s + '+';
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' ')
                continue;
            if(Character.isDigit(c)){
                num = num*10 + (c -'0');
            }
            else{
                if(prevOp == '+'){
                    st.push(num);
                } 
                else if(prevOp == '-'){
                    st.push(-num);
                }
                else if(prevOp == '*'){
                    st.push(st.pop()*num);
                }
                else{
                    st.push(st.pop()/num);
                }
                prevOp = c;
                num = 0;
        }               
     } 
        
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }
}