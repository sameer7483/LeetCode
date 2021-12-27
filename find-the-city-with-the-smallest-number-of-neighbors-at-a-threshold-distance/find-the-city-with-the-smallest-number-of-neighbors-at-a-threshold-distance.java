class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dp[][] = new int[n][n];
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(matrix[i], Integer.MAX_VALUE/2);
        
        for(int i=0;i<edges.length;i++){
            matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    dp[i][j] = 0;
                else
                    dp[i][j] = matrix[i][j];
            }
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                
            }
        } 
        }

        int ans=Integer.MAX_VALUE/2;
        int res=0;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(dp[i][j] <= distanceThreshold){
                    count++;
                }
            }
  //           System.out.println (i + "->" + count);
            if(count <= ans){
                ans = count;
                res = i;
            }
        }
        return res;
    }
}