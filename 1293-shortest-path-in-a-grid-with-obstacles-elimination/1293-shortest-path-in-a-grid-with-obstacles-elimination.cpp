class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        vector<vector<int>> vis(grid.size(), vector<int>(grid[0].size(), -1));
        int m = grid.size();
        int n = grid[0].size();
        queue<vector<int>> q;
        q.push({0, 0, 0, k});
        while(!q.empty()){
            auto t = q.front();
            q.pop();
            int r = t[0]; 
            int c = t[1];
            if(r < 0 || r== m || c< 0 || c==n)
                continue;
            if(r==m-1 && c==n-1)
                return t[2];
            if(grid[r][c] == 1){
                if(t[3] > 0 )
                    t[3]--;
                else
                    continue;
            }
            if(vis[r][c] != -1 && vis[r][c]>=t[3])
                continue;     
            vis[r][c] = t[3];
            q.push({r-1, c, t[2]+1, t[3]});
            q.push({r+1, c, t[2]+1, t[3]});
            q.push({r, c-1, t[2]+1, t[3]});
            q.push({r, c+1, t[2]+1, t[3]});
            
        }
        return -1;
    }
};