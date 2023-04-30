class Solution {
    int[] pa;
    int[] pb;
    int [] sizeA;
    int [] sizeB;
    int count=0;
    
    public int findA(int child){
        if(pa[child] != child){
            pa[child] = findA(pa[pa[child]]);
        }
        return pa[child];
        
    }
    public boolean unionA(int c1, int c2){
        if(findA(c1) == findA(c2)){
           return false;
        }
        pa[findA(c1)] = findA(c2);
        return true;

    }
    
    public int findB(int child){
       if(pb[child] != child){
            pb[child] = findB(pb[pb[child]]);
        }
        return pb[child];
    }
    public boolean unionB(int c1, int c2){
        if(findB(c1) == findB(c2)){
            return false;
        }
        pb[findB(c1)] = findB(c2);
        return true;
        
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        pa = new int[n+1];
        pb = new int[n+1];
        int e1=0, e2=0, result =0;
        for(int i=0;i<=n;i++){
            pa[i] = i;
            pb[i] = i;
        }
        Arrays.sort(edges, new java.util.Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return b[0] - a[0];
    }
});
        for(int i=0;i<edges.length;i++){            
            if(edges[i][0] == 3){
                boolean addA = unionA(edges[i][1], edges[i][2]);
                boolean addB = unionB(edges[i][1], edges[i][2]);
                    
                if(addA)
                    e1++;
                if(addB)
                    e2++;
                if(!addA && !addB)
                    result++;
                    

            }
            else if(edges[i][0] == 1){
               if(unionA(edges[i][1], edges[i][2]))
                   e1++;
                else
                    result++;
            }
            else{
                if(unionB(edges[i][1], edges[i][2]))
                    e2++;
                else
                    result++;
            }
            
 
        }
            if(e1== n-1 && e2== n-1)
                return result;
            else
                return -1;
    }
}