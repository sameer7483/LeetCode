class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int count[] = new int[1002];
        for(int i=0;i<trips.length;i++){
            count[trips[i][1]] += trips[i][0];
            count[trips[i][2]] += - trips[i][0];
        }
        for(int i=0;i<=1001;i++){
            capacity -=count[i];
            if(capacity < 0)
                return false;
        }
        return true;
    }
}