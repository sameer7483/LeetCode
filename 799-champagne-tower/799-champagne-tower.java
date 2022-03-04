class Solution {
    public double champagneTower(int poured, int r, int g) {
        double res[][] = new double[101][101];
        for(int i=0;i<=100;i++)
            Arrays.fill(res[i], 0.0);
        res[0][0] = poured;
        for(int i=0;i<100;i++){
            for(int j=0;j<=i;j++){
                if(res[i][j] >=1){
                res[i+1][j] += (res[i][j]-1)/2.0;
                res[i+1][j+1] += (res[i][j]-1)/2.0;
                res[i][j] = 1.0;                    
                }

            }
        }
        return res[r][g];
    }
}