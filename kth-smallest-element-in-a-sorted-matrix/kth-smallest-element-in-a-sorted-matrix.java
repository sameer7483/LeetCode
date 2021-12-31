class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(q.size() < k)
                    q.add(matrix[i][j]);
                else{
                    if(matrix[i][j] < q.peek()){
                        q.poll();
                        q.add(matrix[i][j]);
                    }
                }
            }
        }
        return q.peek();
    }
}