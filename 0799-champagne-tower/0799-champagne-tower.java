class Solution {
    public double champagneTower(int poured, int qr, int qg) {
        double[][] res = new double[101][101];
        res[0][0] = poured;
        for(int i=0;i<100;i++){
            for(int j=0;j<=i;j++){
                if(res[i][j] >= 1){
                    res[i+1][j] += (res[i][j]-1)/2.0;
                    res[i+1][j+1] += (res[i][j]-1)/2.0;
                    res[i][j] = 1.0;
                }
            }
        }
        return res[qr][qg];
    }
}