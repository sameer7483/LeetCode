class Solution {
    public int countNegatives(int[][] grid) {
        int i = grid.length-1;
        int j = grid[0].length-1;
        int count = 0;
        while(i>=0 && j>=0){
            if(grid[i][j] < 0)
                count++;
            if(j-1 >=0)
                j--;
            else{
                i--;
                j = grid[0].length-1;
            }
        }
        return count;
    }
}