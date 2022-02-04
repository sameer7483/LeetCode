class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> l = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(index[i]==l.size())
                l.add(nums[i]);
            else{
                l.add(index[i], nums[i]);
            }
        }
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}