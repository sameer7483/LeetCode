class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        int n = colors.length();
        int res = 0;
        for(int i=0;i<n;i++){
            if(!st.isEmpty() && st.peek().getKey() == colors.charAt(i)){
                Pair<Character, Integer> p = st.pop();
                if(neededTime[p.getValue()] > neededTime[i]){
                    st.push(p);
                    res += neededTime[i];
                    continue;
                }
                else{
                    res+= neededTime[p.getValue()];
                }
            }
            st.push(new Pair(colors.charAt(i), i));
        }
        return res;
    }
}