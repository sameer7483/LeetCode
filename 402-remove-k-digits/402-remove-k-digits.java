class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        int n = num.length();
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && (st.peek()-'0') > (num.charAt(i)-'0') && (st.size() + n-i) > (n-k))
                st.pop();
            if(st.size() < n-k)
                st.push(num.charAt(i));
        }
        String res = "";
        while(!st.isEmpty()){
            res = st.pop() +res;
        }
        int j=0;
        while(j<res.length()-1 &&res.charAt(j)=='0') j++;
        return res.substring(j);
    }
}