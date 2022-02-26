class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        int i=0;
        int n = s.length();
        while(i<n){
                String num = "";
                while(Character.isDigit(s.charAt(i))){
                    num += s.charAt(i);
                    i++;
                }
                if(!num.isEmpty()){
                    st.push(num);
                    continue;
                }
                if(s.charAt(i) == '['){
                    st.push(String.valueOf('['));
                    i++;
                }
                else if(Character.isLetter(s.charAt(i))){
                    st.push(String.valueOf(s.charAt(i)));
                    i++;
                }
                else if(s.charAt(i) == ']'){
                    String conc = "";
                    while(!st.isEmpty() && !st.peek().equals("[")){
                        conc = st.pop() +conc;
                    }
                    if(!st.isEmpty()){
                        st.pop();
                        int times = Integer.parseInt(st.pop());
                        String str = "";
                        while(times-- > 0){
                            str += conc;
                        }
                        st.push(str);
                    }
                    i++;
                }
            }
        String res = "";
        while(!st.isEmpty()){
            res = st.pop() +res;
        }
        return res;
    }
            
        
        
}