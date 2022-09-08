class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        int first = nums[0];
        if(n==1)
            return first;
        int second = max(first, nums[1]);
        if(n==2)
            return second;
        for(int i=3;i<=n;i++){
            int curr = max(nums[i-1]+first, second);
            first = second;
            second = curr;
        }
        return second;
    }
};