class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int n = temp.length;
        st.push(n-1);
        int[] res = new int[n];
        res[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && temp[st.peek()] <= temp[i])
                st.pop();
            if(!st.isEmpty())
                res[i] = st.peek() - i;
            else
                res[i] = 0;
            st.push(i);
        }
        return res;
    }
}