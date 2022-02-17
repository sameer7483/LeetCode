class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]!=b[0] ? a[0]-b[0]: a[1]-b[1]);
        int i=0,j=0;
        int n = intervals.length;
        if(n==1)
            return intervals;
        List<List<Integer>> res = new ArrayList<>();
        while(i<n){
            int max=intervals[i][1];
            j=i+1;
            while(j< n && max >=intervals[j][0]){
                max = Math.max(intervals[j][1],max);
                j++;
            }
            res.add(Arrays.asList(intervals[i][0], max));
            i=j;
        }

        n = res.size();
        int[][] ans = new int[n][2];
        for(i=0;i<n;i++){
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }
        return ans;
    }
}