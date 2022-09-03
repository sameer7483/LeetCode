class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int i=0;
        int j = height.length-1;
        while(i < j){
            res = Math.max(res, Math.min(height[i], height[j])*(j-i));
            if(height[i] > height[j])
                j--;
            else 
                i++;
        }
        return res;
  }
}