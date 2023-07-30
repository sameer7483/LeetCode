class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1=0, c2 = 0, cand1=-1, cand2 = -1;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i] == cand1)
                c1++;
            else if(nums[i] == cand2)
                c2++;
            else if(c1 == 0){
                cand1 = nums[i];
                c1 = 1;
            }
            else if(c2 == 0){
                cand2 = nums[i];
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1 = 0; c2 =0;
        for(int num : nums){
            if(cand1 == num)
                c1++;
            else if(cand2 == num)
                c2++;
        }
        List<Integer> res = new ArrayList<>();
        if(c1 > n/3)
            res.add(cand1);
        if(c2 > n/3)
            res.add(cand2);
        return res;
    }
}