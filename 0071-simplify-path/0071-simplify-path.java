class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] s = path.split("/");
        for(int i=0;i<s.length;i++){
            if(s[i].isEmpty()) continue;
            if("..".equals(s[i])){
                if(!st.isEmpty())
                    st.pop();
            }
            else if(".".equals(s[i]))
                continue;
            else
                st.push(s[i]);
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