class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0] != b[0] ? a[0]-b[0]: b[1]-a[1]);
        int i=0, j=0;
        int n = intervals.length;
        int count = 0;
        while(i < n){
            count++;
            j= i+1;
            while(j< n && intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1]){
                j++;
            }
            i=j;
        }
        return count;
    }
}