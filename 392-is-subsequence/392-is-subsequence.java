class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0, j=0;
        int m = s.length();
        int n = t.length();
        while(i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==m;
    }
    
    public int lis(String s, int m, String t, int n){
    int[][]  arr= new int[s.length()+1][t.length()+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    arr[i][j] = 0;
                }
            }
        }
        for(int i=1;i<=m; i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    arr[i][j] = 1 + arr[i-1][j-1];
                    }
                else
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
            }
        }
        
        return arr[m][n];

    }
}