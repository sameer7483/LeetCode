class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> vis = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] p = q.poll();
                int r = p[0];
                int c = p[1];
                
                if(r-1 >= 0 && grid[r-1][c] == 1){
                    q.add(new int[]{r-1, c});
                    grid[r-1][c] = 2;
                }
                    
                if(r+1 < m && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    q.add(new int[]{r+1, c});
                }
                    
                if(c-1 >= 0 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    q.add(new int[]{r, c-1});
                }
                    
                if(c+1 < n && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    q.add(new int[]{r, c+1});
                }
                    
            }
            if(!q.isEmpty())
                res++;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return res;
        
        
    }
}