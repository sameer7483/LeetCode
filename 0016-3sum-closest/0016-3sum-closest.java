class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target) < min){
                        min = Math.abs(sum-target);
                        res = sum;
                    }
                if(sum > target){
                    k--;
                }
                else if(sum < target){
                    j++;
                }
                else{
                    return sum;
                }
            }
        }
        return res;
    }
}