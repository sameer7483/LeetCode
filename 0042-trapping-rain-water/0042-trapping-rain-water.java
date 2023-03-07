class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lo = 0;
        int hi = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0 ;
        while(lo <= hi){
            if(leftMax <= rightMax){
                res += Math.max(0, leftMax-height[lo]);
                leftMax = Math.max(leftMax, height[lo]);
                lo++;
            }
            else{
                res += Math.max(0, rightMax-height[hi]);
                rightMax = Math.max(rightMax, height[hi]);
                hi--;                
            }
        }
        return res;
    }
}