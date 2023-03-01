class Solution {
    private void sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = partition(nums, l, r);
        sort(nums, l, mid);
        sort(nums, mid + 1, r);
    }
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
    
    public int[] sortArray(int[] nums) {
        sort(nums, 0 , nums.length-1);
        return nums;
    }
}