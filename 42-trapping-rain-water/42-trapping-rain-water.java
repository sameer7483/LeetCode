class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        left[0] = 0;
        int[] right = new int[n];
        right[n-1] = 0;
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            if(height[i] < Math.min(left[i], right[i]))
            sum += Math.min(left[i], right[i])-height[i];
        }
        return sum;
    }
}