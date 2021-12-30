class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j=0 ;
        int ans = 0;
        int flips=0;
        int[] wasFlipped = new int[n];
        while(j<n){
            
            if(j-i+1 > k){
                if(wasFlipped[i] == 1)
                    flips -=1;
                i++;
            }
            
            if(j-i+1 <= k){
                if(flips % 2 == nums[j]){
                    if(j+k > n)
                        return -1;
                    flips+=1;
                    wasFlipped[j] = 1;
                    ans++;
                }
            }
            j++;
        }
        return ans;
    }
}