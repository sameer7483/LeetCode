class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map= new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        int rank=1;
        for(int i=0;i<score.length;i++)
            q.add(score[i]);
        while(!q.isEmpty()){
            map.put(q.poll(), rank++);
        }
        int n = score.length;
        String[] res = new String[n];
        for(int i=0;i<n;i++){
            if(map.get(score[i]) == 1){
                res[i] = "Gold Medal";
            }
            else if(map.get(score[i]) == 2){
                res[i] = "Silver Medal";
            }
            else if(map.get(score[i]) == 3){
                res[i] = "Bronze Medal";
            }
            else
                res[i] = String.valueOf(map.get(score[i]));
        }
        return res;
    }
}