class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        int end = intervals[0][1];
        int res = 0;
        int n = intervals.length;
        for(int i=1;i<n;i++){
            if(intervals[i][0] < end){
                res++;
            }
            else{
                end = intervals[i][1];
            }
        }
        return res;
        
    }
}