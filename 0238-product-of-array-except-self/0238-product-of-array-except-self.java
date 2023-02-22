class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        l[0] = 1;
        int[] r = new int[n];
        r[n-1] = 1;
        for(int i=1;i<n;i++){
            l[i] = l[i-1]*nums[i-1];
            r[n-i-1] = r[n-i]*nums[n-i];
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = l[i]*r[i];
        }
        return res;
    }
}