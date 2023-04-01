class NumMatrix {
    public int[][] preSum;
    public NumMatrix(int[][] mat) {
        preSum = new int[mat.length][mat[0].length];
        preSum[0][0] = mat[0][0];
        for(int i=1;i<mat[0].length;i++)
            preSum[0][i] += mat[0][i]+preSum[0][i-1];
        for(int i=1;i<mat.length;i++)
            preSum[i][0] += mat[i][0]+preSum[i-1][0];
        for(int i=1;i<mat.length;i++){
            for(int j=1;j<mat[0].length;j++){
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + mat[i][j];
                // System.out.print(preSum[i][j]+" ");
            }
            // System.out.println();
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2][col2] - (col1-1 >= 0 ? preSum[row2][col1-1] : 0) - (row1-1 >= 0 ? preSum[row1-1][col2] :0) + (row1-1 >= 0 && col1-1 >= 0 ?preSum[row1-1][col1-1] : 0) ;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */