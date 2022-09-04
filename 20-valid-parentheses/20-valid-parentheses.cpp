class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        int n = s.length();
        char arr[] = {'{', '[', '('};
        for(int i=0;i<n;i++){
            if(!st.empty() && s[i] == ')' && st.top() != '(')
                return false;
            else if(!st.empty() && s[i] == ']' && st.top() != '[')
                return false;
            else if(!st.empty() && s[i] == '}' && st.top() != '{')
                return false;
            else if(find(begin(arr), end(arr), s[i]) != end(arr))
                st.push(s[i]);
            else if (st.empty())
                return false;
            else st.pop();
            
        }
        return st.empty();
    }
};