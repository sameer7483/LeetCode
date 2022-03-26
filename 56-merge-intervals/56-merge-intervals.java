class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        int n = intervals.length;
        List<List<Integer>> res = new ArrayList<>();
        int i=0;
        int j=0;
        int end = intervals[0][1];
        while(j<n){
            end = intervals[i][1];
            j= i+1;
            while(j < n && intervals[j][0] <= end){
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            res.add(Arrays.asList(intervals[i][0], end));
            i = j;
        }
        int[][] ans = new int[res.size()][2];
        for(i=0;i<res.size();i++){
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }
        return ans;
    }
}