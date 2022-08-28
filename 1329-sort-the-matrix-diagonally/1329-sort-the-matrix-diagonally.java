class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j< n;j++){
                PriorityQueue<Integer> q = map.getOrDefault(i-j, new PriorityQueue<Integer>());
                q.add(mat[i][j]);
                map.put(i-j, q);
            }
        }
        for(int i=0;i<m;i++){
            for(int j = 0;j< n;j++){
                mat[i][j] = map.get(i-j).poll();
            }
        }
        return mat;
    }
}