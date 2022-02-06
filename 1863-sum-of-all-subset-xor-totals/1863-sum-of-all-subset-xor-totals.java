class Solution {
    public int subsetXORSum(int[] nums) {
       return util(nums, 0 ,0);
    }
    
    public int util(int[] nums,int index, int currentXor){
        if (index == nums.length) return currentXor;
        
        // calculate sum of xor with current element
        int withElement = util(nums, index + 1, currentXor ^ nums[index]);
        
        // calculate sum of xor without current element
        int withoutElement = util(nums, index + 1, currentXor);
        
        // return sum of xors from recursion
        return withElement + withoutElement;
    }
}