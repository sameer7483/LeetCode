class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n-2;i++){
            int diff = nums[i+1]-nums[i];
            int j;
            for( j=i+2;j<n;j++){
                if(nums[j]-nums[j-1] != diff)
                    break;
            }
            if(j > i+2){
                ans += j-i-2;
            }
        }
        return ans;

    }
}