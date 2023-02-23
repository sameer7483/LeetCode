class Solution {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length-1;
        int res = 0;
        while(lo < hi){
            res = Math.max(res, (hi-lo)*Math.min(height[lo], height[hi]));
            if(height[lo] <= height[hi]){
                lo += 1;
            }
            else{
                hi -= 1;
            }
        }
        return res;
    }
}