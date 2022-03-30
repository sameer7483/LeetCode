class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // x = j+n*i
        //i = x/n
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0;
        int hi = n*m-1;
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;
            int i = mid/n;
            int j = mid - n*i;
            if(matrix[i][j] < target){
                lo = mid+1;
            }
            else if(matrix[i][j] > target)
                hi = mid-1;
            else
                return true;
        }
        return false;
    }
}