class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        unordered_map<int, priority_queue<int, vector<int>, greater<int>>> my_map;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(my_map.find(i-j) == my_map.end()){
                    priority_queue<int, vector<int>, greater<int>> q;
                    q.push(mat[i][j]);
                    my_map[i-j] = q;
                }
                else{
                    my_map[i-j].push(mat[i][j]);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = my_map[i-j].top();
                my_map[i-j].pop();
            }
        }
        return mat;
    }
};