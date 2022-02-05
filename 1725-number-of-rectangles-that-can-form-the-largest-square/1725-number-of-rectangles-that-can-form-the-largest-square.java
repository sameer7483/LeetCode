class Solution {
    public int countGoodRectangles(int[][] rect) {
        int count = 0;
        int max = 0;
        for(int i=0;i<rect.length;i++){
            if(Math.min(rect[i][0], rect[i][1]) > max){
                max = Math.min(rect[i][0], rect[i][1]);
                count = 1;
            }
            else if(Math.min(rect[i][0], rect[i][1]) == max)
                count++;
        }
        return count;
    }
}