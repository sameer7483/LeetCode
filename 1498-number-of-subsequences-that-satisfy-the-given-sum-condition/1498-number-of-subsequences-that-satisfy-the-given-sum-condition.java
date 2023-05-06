class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int mod = (int)(1e9 + 7);
        int[] pow = new int[n];
        pow[0] = 1;
        for(int i=1;i<n;i++){
            pow[i] = pow[i-1]*2 % mod;
        }
        int res = 0;
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            if(nums[lo] + nums[hi] > target)
                hi--;
            else{
                res = (res + pow[hi-lo])%mod;
                lo++;
            }
        }
        return res;
        
    }
    

}