class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i, j = -1, len(nums)
        k = 0
        while k < j:
            if nums[k] == 1:
                k += 1
            elif nums[k] == 2:
                nums[k], nums[j-1] = nums[j-1], nums[k]
                j -= 1
            else:
                nums[k], nums[i+1] = nums[i+1], nums[k]
                i += 1
                k += 1
        
                
                
                
        