class Solution {
    public int[][] insert(int[][] intervals, int[] ni) {
        int n = intervals.length;
        List<int[]> res = Arrays.stream(intervals).collect(Collectors.toList());
        int i=0;
        boolean flag =false;
        for( i=0;i<intervals.length;i++){
            if(res.get(i)[0]> ni[0]){
                res.add(i, ni);
                flag = true;
                break;
            }
        }
        if(!flag)
            res.add(ni);
        //merge interval;
        List<List<Integer>> ans = new ArrayList<>();
        i=0;
        while(i < res.size()){
            int end = res.get(i)[1];
            int j= i+1;
            
            while(j<res.size() && res.get(j)[0] <= end){
                end = Math.max(end, res.get(j)[1]);
                
                j++;
            }
            
            ans.add(Arrays.asList(res.get(i)[0], end));
            i = j;
        }
        int[][] ret = new int[ans.size()][2];
        
        for( i=0;i<ans.size();i++){
            ret[i][0] = ans.get(i).get(0);
            ret[i][1] = ans.get(i).get(1);
        }
        return ret;
        
    }
}