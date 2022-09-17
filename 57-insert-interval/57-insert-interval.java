class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = Arrays.stream(intervals).collect(Collectors.toList());
        int i = 0;
        int n = intervals.length;
        boolean flag = false;
        while(i< n){
            if(intervals[i][0] > newInterval[0]){
                res.add(i, newInterval);
                flag = true;
                break;
            }   
            i++;
        }
        if(!flag){
            res.add(newInterval);
        }
        
        i = 0;
        
        List<List<Integer>> ans = new ArrayList<>();
        while(i < res.size()){
            int end = res.get(i)[1];
            int j = i+1;
            while(j< res.size() && res.get(j)[0] <= end){
                end = Math.max(end, res.get(j)[1]);
                j++;
            }
            ans.add(Arrays.asList(res.get(i)[0], end));
            i = j;
        }
        int[][] inserted = new int[ans.size()][2];
        for( i=0;i<ans.size();i++){
            inserted[i][0] = ans.get(i).get(0);
            inserted[i][1] = ans.get(i).get(1);
        }
        return inserted;
        
    }
    
}