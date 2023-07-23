class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int currMin = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int j = i+1;
            int k = n-1;
            while(j < k){
                int currSum = nums[i] + nums[j] + nums[k];
                if(Math.abs(currSum-target) < currMin){
                    currMin = Math.abs(currSum-target);
                    res = currSum;
                }
                if(currSum > target)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }
}