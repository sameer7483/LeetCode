class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int lo = i+1;
            int hi = n-1;
            while(lo < hi){
                if(target == nums[lo]+nums[hi]){
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo += 1;
                    hi -= 1;                    
                    while(lo < hi && nums[lo] == nums[lo-1])
                        lo += 1;
                    while(hi != n-1 && lo < hi && nums[hi] == nums[hi+1])
                        hi -= 1;

                }
                else if(target > nums[lo]+nums[hi]){
                    lo += 1;
                }
                else{
                    hi -= 1;
                }
            }
            
        }
        return res;
    }
}