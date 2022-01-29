class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        int max = 0;
        int i=0;
        int n = h.length;
        for(i=0;i<h.length;i++){
            int idx = i;
            while(!st.isEmpty() && st.peek().getValue() > h[i]){
                int val = st.peek().getValue();
                idx = st.pop().getKey();
                max = Math.max(max, val* (i-idx));
            }
            st.push(new Pair(idx, h[i]));
        }
        while(!st.isEmpty()){
            max = Math.max(max,st.peek().getValue() * (n-st.pop().getKey()));
        }
        return max;
    }
}