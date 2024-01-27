class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
                for(int k=j+1;k< n;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(Math.abs(sum-target) < min){
                        min = Math.abs(sum-target);
                        res = sum;
                    }
                }
        }
        return res;
    }
}