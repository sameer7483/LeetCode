class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int currMin = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(Math.abs(target-(nums[i]+nums[j]+nums[k])) < currMin){
                        currMin = Math.abs(target-(nums[i]+nums[j]+nums[k]));
                        res = nums[i]+nums[j]+nums[k];
                    }
                        
                }
            }
        }
        return res;
    }
}