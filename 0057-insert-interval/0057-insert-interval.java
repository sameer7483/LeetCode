class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> inter = Arrays.stream(intervals).collect(Collectors.toList());
        if(intervals.length ==0)
            return new int[][]{newInterval};
        int j = 0;
        while(j < inter.size() && inter.get(j)[0]<= newInterval[0])
            j++;
        inter.add(j, newInterval);
        List<int[]> res = new ArrayList<>();
        int i=0;
        while(i<inter.size()){
            int start = inter.get(i)[0];
            int end = inter.get(i)[1];            
            j = i+1;
            while(j < inter.size() && end >= inter.get(j)[0]){
                end = Math.max(end, inter.get(j)[1]);
                j++;
            }
            res.add(new int[]{start, end});
            i=j;
        }
        int[][] ans = new int[res.size()][2];
        for( i=0;i<res.size();i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
        
    }
}