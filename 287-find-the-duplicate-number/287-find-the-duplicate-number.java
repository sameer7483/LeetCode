class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1)
            return -1;
        int fast = 0;
        int slow = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
                break;
        }
        fast = 0;
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
            if(fast == slow)
                return fast;
        }
        return -1;
    }
}