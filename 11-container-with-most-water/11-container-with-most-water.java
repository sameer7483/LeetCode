class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0, j= n-1;
        int res = 0;
        while(i < j){
            res = Math.max(res, (j-i) * Math.min(height[i], height[j]));
            if(height[i] > height[j])
                j--;
            else 
                i++;
        }
        return res;
 }
}