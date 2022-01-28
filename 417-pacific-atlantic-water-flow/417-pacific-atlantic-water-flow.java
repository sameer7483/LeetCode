class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;   
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();
        for(int c=0;c<n;c++){
            dfs(heights, 0, c, pac, heights[0][c]);
            dfs(heights, m-1, c, atl, heights[m-1][c]);
        }
        for(int r=0;r<m;r++){
            dfs(heights, r, 0, pac, heights[r][0]);
            dfs(heights, r, n-1, atl, heights[r][n-1]);
        }    
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(pac.contains(Arrays.asList(i, j)) && atl.contains(Arrays.asList(i, j)))
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
    
    public void dfs(int[][] heights, int i, int j, Set<List<Integer>> s, int prevHeight){
        
        int m = heights.length;
        int n = heights[0].length;
        if(i >=m || i<0 || j >= n || j< 0 || s.contains(Arrays.asList(i,j)) || heights[i][j] < prevHeight)
            return ;
        s.add(Arrays.asList(i,j));
        dfs(heights, i+1, j, s, heights[i][j]);
        dfs(heights, i-1, j, s, heights[i][j]);
        dfs(heights, i, j+1, s, heights[i][j]);
        dfs(heights, i, j-1, s, heights[i][j]);  
    }
}