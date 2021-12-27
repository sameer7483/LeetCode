class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        //1 blue
        //-1 red
        //0 no color;
        for(int i=0;i<n;i++){
            if(color[i]==0 && !valid(graph, color, 1, i)){
                return false;
            }
        }
        return true;
        
    }
    
    public boolean valid(int[][] graph, int[] color, int c, int i){
        if(color[i] != 0 && color[i] != c)
            return false;
        if(color[i] != 0 && color[i] == c)
            return true;
        color[i]=c;
        for(int j=0;j<graph[i].length;j++){
            if(!valid(graph, color, -c, graph[i][j]))
                return false;
        }
        return true;
    }
}