class Solution {
    public void setZeroes(int[][] mat) {
        int col0 = 1;
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    if(j != 0)
                        mat[0][j] = 0;
                    if(j==0)
                        col0 = 0;
                }
            }
        }
        for(int i=m-1;i>=0;i--){
            int j;
            for(j=n-1;j>=1;j--){
                if(mat[i][0] == 0 || mat[0][j] == 0)
                    mat[i][j] = 0;
            }
            if(j==0 && col0 == 0)
                mat[i][0] = 0;
        }
    }
}