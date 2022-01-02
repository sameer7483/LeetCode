class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return util(students, mentors, students.length, new boolean[mentors.length]);
    }
    
    public int util(int[][] students, int[][] mentors, int m, boolean[] taken){
        if(m==0)
            return 0;
        int len = mentors.length;
        int score=0;
        for(int i=len-1;i>=0;i--){
            if(!taken[i]){
                taken[i] = true;
                score = Math.max(score, getScore(students[m-1], mentors[i]) + util(students, mentors, m-1, taken));
                taken[i] = false;
            }
        }
        return score;
        
    }
    
    public int getScore(int[] st, int[] ment){
        int n = st.length;
        int score=0;
        for(int i=0;i<n;i++){
            if(st[i] == ment[i])
                score++;
        }
        return score;
    }
    
    
}