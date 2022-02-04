class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] count = new int[101];
        int n = nums.length;
        for(int i=0;i<n;i++)
            count[nums[i]]++;
        int i=0, j=k;
        int res =0;
        while(j<101){
            res+= count[i]*count[j];
            i++;
            j++;
        }
        return res;
    }
}