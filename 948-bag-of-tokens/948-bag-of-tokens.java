class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int res = 0, i=0,j= tokens.length-1;
        int point = 0;
        Arrays.sort(tokens);
        while(i <= j){
            if(power >= tokens[i]){
                power -= tokens[i];
                i++;
                point++;
                res = Math.max(res, point);
            }
            else if(point >= 1){
                power += tokens[j];
                j--;
                point--;
            }
            else{
                break;
            }
        }
        return res;
    }
    
}