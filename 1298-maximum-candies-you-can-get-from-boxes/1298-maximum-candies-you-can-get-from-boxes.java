class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> found = new HashSet<>();
        for(int b : initialBoxes){
            q.add(b);
            found.add(b);
        }
            
        int res = 0;
        Set<Integer> vis = new HashSet<>();

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int p = q.poll();
                if(vis.contains(p))
                    continue;
                if(status[p] == 1){
                    res += candies[p];
                    vis.add(p);
                    for(int b : containedBoxes[p]){
                        q.add(b);
                        found.add(b);
                    } 
                    for(int k : keys[p]){
                        status[k] = 1; 
                        if(found.contains(k))
                            q.add(k);
                    }
                                           
                }
            }

        }
        return res;
    }
}