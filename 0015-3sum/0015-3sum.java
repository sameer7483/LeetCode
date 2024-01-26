class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            int lo = i+1;
            int hi = n-1;
            while(lo < hi){
                int sum = nums[i]+nums[lo] + nums[hi];
                if(sum > 0){
                    hi--;
                }
                else if(sum < 0){
                    lo++;
                }
                else{
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while(lo < n && nums[lo] == nums[lo-1])
                        lo++;
                    while(hi > lo && nums[hi] == nums[hi+1])
                        hi--;
                }
            }
        }
        return res;
    }
}