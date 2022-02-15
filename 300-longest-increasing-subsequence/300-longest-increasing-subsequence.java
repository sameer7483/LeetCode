class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        //dp[i] lis in first i
        // int n = nums.length;
        // dp = new int[n];
        // Arrays.fill(dp, 1);
        // int res = 1;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<i;j++){
        //         if(nums[i] > nums[j]){
        //             dp[i] = Math.max(dp[i], 1+dp[j]);
        //         }
        //     }
        //     res = Math.max(res, dp[i]);
        // }
        // return res;
        return optimal(nums);
    }
    public int optimal(int nums[]){
        int n= nums.length;
        List<Integer> seq = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(seq.isEmpty() || nums[i] > seq.get(seq.size()-1)){
                seq.add(nums[i]);
            }
            else{
                int idx = binarySearch(seq, nums[i]);
                seq.set(idx, nums[i]);
            }
        }
        return seq.size();
    }
    
    public int binarySearch(List<Integer> seq, int key){
        int lo= 0, hi = seq.size()-1;
        while(lo < hi){
            int mid = lo+(hi-lo)/2;
            if(seq.get(mid) < key){
                lo = mid+1;
            }
            else if(seq.get(mid) > key)
                hi = mid;
            else
                return mid;
            
        }
        return lo;
    }
    
}