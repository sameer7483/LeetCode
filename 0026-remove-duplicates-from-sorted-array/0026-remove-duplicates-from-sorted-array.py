class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        idx = 0
        for i in range(len(nums)-1):
            if nums[i] != nums[i+1]:
                nums[idx] = nums[i]
                idx += 1
        nums[idx] = nums[len(nums)-1]
        idx += 1
        return idx
        