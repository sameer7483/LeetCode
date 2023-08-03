class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        path.add(0);
        util(graph, 0, path, res, vis);
        return res;
    }
    
    public void util(int[][] graph, int u, List<Integer> path, List<List<Integer>> res, Set<Integer> vis){
        if(vis.contains(u))
            return;
        if(u == graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        vis.add(u);
        for(int v : graph[u]){
            path.add(v);
            util(graph, v, path, res, vis);
            path.remove(path.size()-1);
        }
        vis.remove(u);
    }
}