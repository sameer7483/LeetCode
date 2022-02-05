class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int i=1;
        int sum = 0;
        for(i=1;i<points.length;i++){
            sum += Math.max(Math.abs(points[i][1]-points[i-1][1]), Math.abs(points[i][0]-points[i-1][0]));
        }
        return sum;
    }
}