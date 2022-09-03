class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        for(int k=0;k<n;k++){
            if(k != 0 && nums[k]==nums[k-1])
                continue;
            int target = -nums[k];
            int i = k+1;
            int j = n-1;
            while(i< j){
                if(nums[i]+nums[j] > target){
                    j--;
                }
                else if(nums[i] + nums[j] < target){
                    i++;
                }
                else{
                    vector<int> triplet({nums[k], nums[i], nums[j]});
                    res.push_back(triplet);
                    i++;
                    j--;
                    while(i<j && nums[i] == nums[i-1]) 
                        i++;
                }
            } 
        }
        return res;
    }
};