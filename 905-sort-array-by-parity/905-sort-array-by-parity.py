class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        i = -1
        j = 0
        while j < len(nums):
            if nums[j] % 2 == 0:
                i = i+1
                nums[i], nums[j] = nums[j], nums[i]
            j +=1
        return nums
        