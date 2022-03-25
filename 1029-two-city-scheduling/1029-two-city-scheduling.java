class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((a, b)-> b.getKey() - a.getKey());
        int n = costs.length;
        for(int i=0;i<n;i++){
            q.add(new Pair(costs[i][1]-costs[i][0], i));
        }
        int j =0;
        int res = 0;
        while(j<n/2){
            res += costs[q.poll().getValue()][0];
            j++;
        }
        j=0;
         while(j<n/2){
            res += costs[q.poll().getValue()][1];
            j++;
        }  
        return res;
    }
}