class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=1;i<=n;i++)
            adj.put(i, new ArrayList<>());
        for(int i=0;i<dislikes.length;i++){
            List<Integer> l1 = adj.get(dislikes[i][0]);
            List<Integer> l2 = adj.get(dislikes[i][1]);
            l1.add(dislikes[i][1]);
            l2.add(dislikes[i][0]);
            adj.put(dislikes[i][0], l1);
            adj.put(dislikes[i][1], l2);
        }
        int color[] = new int[n];
        for(int i=0;i<n;i++){
            if(color[i] ==0 && !valid(i+1,1,color, adj))
                return false;
        }
        return true;
    }
    
    public boolean valid(int i,int c, int[] color, Map<Integer, List<Integer>> adj){
        if(color[i-1] != 0 && color[i-1] != c)
            return false;
        if(color[i-1] != 0 && color[i-1] == c)
            return true;
        color[i-1] = c;
        for(int j=0;j<adj.get(i).size();j++){
            if(!valid(adj.get(i).get(j), -c, color, adj))
                return false;
        }
        return true;
    }
}