class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] *=-1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }                                                     
         return res;                                                   
    }
}