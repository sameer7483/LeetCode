class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i=0;
        for(int p : pushed){
            st.push(p);
            while(i < popped.length && !st.isEmpty() && st.peek() == popped[i]){
                st.pop();
                i++;
            }    
        }
        while(i< popped.length && st.peek() == popped[i]){
            st.pop();
            i++;
        }
        return st.isEmpty();
    }
}