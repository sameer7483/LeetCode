class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((a,b)-> a.getKey()!=b.getKey()?b.getKey()-a.getKey(): b.getValue() -a.getValue());
        for(int i=0;i<mat.length;i++){
            int str= getFirst(mat[i]);
            if(q.size() < k){
                q.add(new Pair(str, i));
            }
            else{
                if(str < q.peek().getKey()){
                    q.poll();
                    q.add(new Pair(str, i));
                }
            }
        }
        int[] res = new int[k];
        while(!q.isEmpty()){
            res[--k] = q.poll().getValue(); 
        }
        return res;
        
    }
    
    public int getFirst(int[] arr){
        int key = 0;
        int lo=0;
        int hi=arr.length;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > key){
                lo = mid+1;
            }
            else 
                hi = mid;
        }
        return lo;
    }
    
}