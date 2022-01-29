class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        int max = 0;
        int n = h.length;
        for(int i=0;i<h.length;i++){
            int idx = i;
            while(!st.isEmpty() && st.peek().getValue() >= h[i]){
                Pair<Integer, Integer> p = st.pop();
                max = Math.max(max, p.getValue()*(i-p.getKey()));
                idx = p.getKey();
            }
            st.push(new Pair(idx, h[i]));
        }
        while(!st.isEmpty()){
                Pair<Integer, Integer> p = st.pop();
                max = Math.max(max, p.getValue()*(n-p.getKey()));            
        }
        return max;
    }
}