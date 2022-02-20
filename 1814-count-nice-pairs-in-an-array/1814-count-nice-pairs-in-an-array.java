class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        long ans = 0;
        int mod = (int)(1e9+7);
        for(int i=0;i<nums.length;i++){
            int diff = nums[i] - reverse(nums[i]);
            if(m.containsKey(diff)){
                ans =(ans+ m.get(diff))%mod;
                m.put(diff, m.get(diff)+1);
            }
            else{
                m.put(diff, 1);
            } 
        }
        return (int)ans%mod;
    }
    
    public int reverse(int num){
        int rev = 0;
        while(num > 0){
            rev *= 10;
            rev += num%10;
            num = num/10;
        }
        return rev;
    }
}