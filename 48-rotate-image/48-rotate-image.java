class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i=0, j=m-1;
        while(i < j){
            for(int k=0;k<n;k++){
                int temp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = temp;
            }
            i++;
            j--;
        }
        i = 0;
        while(i < m){
            for(j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            i++;
        }
        
    }
}