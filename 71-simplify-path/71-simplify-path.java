class Solution {
    public String simplifyPath(String path) {
        String[] str =path.split("/");
        Stack<String> st = new Stack<>();
        for(String s : str){
            if(!s.trim().isEmpty()){
                if("..".equals(s)){
                    if(!st.isEmpty())
                        st.pop();
                }
                else if(".".equals(s)) continue;
                else{
                    st.push(s);
                }
            }
        }
        String res = "";
        if(st.isEmpty())
            return "/";
        while(!st.isEmpty()){
            res = "/"+st.pop() +res;
        }
        return res;
        
    }
}