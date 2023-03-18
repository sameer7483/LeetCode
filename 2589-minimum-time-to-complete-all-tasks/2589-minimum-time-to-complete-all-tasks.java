class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b)->a[1]-b[1] != 0 ? a[1]-b[1] : a[0]-b[0]);
        int res = 0;
        Set<Integer> used = new HashSet<>();
        for(int[] task : tasks){
            int alreadyused = 0;
            for(int i=task[1];i>=task[0];i--){
                if(used.contains(i))
                    alreadyused++;
            }
            int timeLeft = task[2]-alreadyused;
            for(int i=task[1];timeLeft > 0 ;i--){
                if(!used.contains(i)){
                used.add(i);
                res++;
                timeLeft--;                    
                }

            }
        }
        return res;
    }
}