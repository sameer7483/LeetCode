class Solution {
    boolean[] selected;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        selected = new boolean[n];
        for(int i=0;i<n;i++)
            sum += nums[i];
        if(sum % k != 0)
            return false;
        return util(nums, n, n, k, sum/k, sum/k);
        
        
    }
    
    public boolean util(int[] nums, int n,int n1, int k, int target, int sum){
        if(k==0)
            return true;
        if(target != 0 && n==0)
            return false;
        if(target == 0)
            return util(nums,n1, n1, k-1,sum, sum);
        
        if(target >= nums[n-1] && !selected[n-1]){
            selected[n-1] = true;
            if(util(nums, n-1, n1, k, target-nums[n-1], sum))
                return true;
            selected[n-1] = false;
        }
        return util(nums, n-1, n1, k, target, sum);

        
        
    }
    
    
}