class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> p = new HashSet<>();
        Set<List<Integer>> a = new HashSet<>();
        int m = heights.length;
        int n = heights[0].length;
        for(int i=0;i<m;i++){
            dfs(heights, i,0,p,0);
            dfs(heights, i, n-1,a, 0);
        }
        for(int i=0;i<n;i++){
            dfs(heights, 0,i,p,0);
            dfs(heights, m-1, i,a, 0);
        }  
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> l : p){
            if(a.contains(l)){
                res.add(l);
            }
   
        }
        return res;
    }

    
    public void dfs(int[][] heights, int r, int c, Set<List<Integer>> s, int prevHeight){
        
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || s.contains(Arrays.asList(r,c)) || heights[r][c] < prevHeight)
            return;
        s.add(Arrays.asList(r,c));
        dfs(heights, r+1, c, s, heights[r][c]);
        dfs(heights, r-1, c, s, heights[r][c]);
        dfs(heights, r, c+1, s, heights[r][c]);
        dfs(heights, r, c-1, s, heights[r][c]);
    }
}