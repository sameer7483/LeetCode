class Solution {
    public void sortColors(int[] nums) {
        //0..i is 0
        // i+1..j is 1
        // j..k is unclassified
        // k..n is 2
        int i=-1;
        int j=0;
        int k =nums.length;
        while(j < k){
            if(nums[j] == 0){
                int temp = nums[i+1];
                nums[i+1] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
            else if(nums[j] == 1)
                j++;
            else{
                int temp = nums[j];
                nums[j] = nums[k-1];
                nums[k-1] = temp;  
                k--;
            }
    }
}
}