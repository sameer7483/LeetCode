class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            q.add(nums[i]);
        }
        for(int i=0;i<n;i++){
            nums[i] = q.poll();
        }
        return nums;
    }
}