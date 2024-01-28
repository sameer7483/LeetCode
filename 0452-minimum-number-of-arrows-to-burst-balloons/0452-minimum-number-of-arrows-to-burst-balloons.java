class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        int i = 0;
        int j = 1;
        while(j < points.length){
            if(points[j][0] <= points[i][1]){
                j++;
                continue;
            }
            
            res++;
            i = j;  
        }
        return res;
    }
}