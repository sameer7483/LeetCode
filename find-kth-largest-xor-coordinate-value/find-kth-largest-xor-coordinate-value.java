class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j] = matrix[i][j-1] ^ matrix[i][j];
            }
        }
        
        for(int j=0;j<n;j++){
            for(int i=1;i<m;i++){
                matrix[i][j] = matrix[i-1][j] ^ matrix[i][j];
            }
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(q.size() < k){
                    q.add(matrix[i][j]);
                }
                else{
                    if(matrix[i][j] > q.peek()){
                        q.poll();
                        q.add(matrix[i][j]);
                    }
                }
            }
        }
        return q.peek();
        
    }
}