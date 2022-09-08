class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n==1)
            return nums[0];
        if(n==2)
            return max(nums[0], nums[1]);
        return max(util(nums, 0), util(nums, 1));
        
    }
    int util(vector<int>&nums, int start){
        int first = nums[start];
        int second = max(nums[start], nums[start+1]);
        int n = nums.size();
        for(int i=start+3;i<=n-!start;i++){
            int curr = max(nums[i-1]+first, second);
            first = second;
            second = curr;
        }
        return second;
    }
};