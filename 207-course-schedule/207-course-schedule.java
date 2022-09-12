class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0;i<prereq.length;i++){
            List<Integer> l = adj.getOrDefault(prereq[i][0], new ArrayList<>());
            l.add(prereq[i][1]);
            adj.put(prereq[i][0], l);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                 if(isCycle(adj, i, visited, new HashSet<>()))
                    return false;               
            }

        }
        return true;
        
    }
    
    public boolean isCycle(Map<Integer, List<Integer>> adj, int u, Set<Integer> visited, Set<Integer> recVisited){
        if(recVisited.contains(u))
            return true;
        if(visited.contains(u))
            return false;;
        recVisited.add(u);
        for(Integer v : adj.getOrDefault(u, new ArrayList<>())){
            if(isCycle(adj, v, visited, recVisited))
                return true;
        }
        recVisited.remove(u);
        visited.add(u);
        return false;
    }
}