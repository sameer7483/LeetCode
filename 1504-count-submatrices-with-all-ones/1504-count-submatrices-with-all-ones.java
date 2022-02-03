class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count += util(mat, i, j);
            }
        } 
        return count;
    }
    public int util(int[][] mat, int x, int y){
        int m = mat.length;
        int n = mat[0].length;
        int bound = n;
        int count=0;
        for(int i=x;i<m;i++){
            for(int j=y;j<bound;j++){
                if(mat[i][j]==1)
                    count+=1;
                else
                    bound = j;
            }
        }
        return count;
    }
}