class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        int i=0, j=0;
        while(j < nums.length){
            if(s.contains(nums[j]))
                return true;
            s.add(nums[j]);
            j++;
            if(j-i <= k) continue;
            s.remove(nums[i]);
            i++;
        }
        return false;
    }
}