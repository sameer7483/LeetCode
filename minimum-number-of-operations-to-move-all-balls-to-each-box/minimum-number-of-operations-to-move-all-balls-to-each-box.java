class Solution {
    public int[] minOperations(String boxes) {
        List<Integer> l = new ArrayList<>();
        int n = boxes.length();
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1')
                l.add(i);
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<l.size();j++){
                ans[i]+= Math.abs(i-l.get(j));
            }
        }
        return ans;
    }
}