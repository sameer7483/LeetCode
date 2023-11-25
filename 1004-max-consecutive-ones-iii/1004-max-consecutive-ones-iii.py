class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        zeros = 0
        j = 0
        i = 0
        res = 0
        if sum(nums) == 0 and k==0:
            return 0
        while j < len(nums):
            if nums[j] == 0:
                zeros += 1
            while i < j and zeros > k:
                if nums[i] == 0:
                    zeros -= 1
                i += 1
            res = max(res, j-i+1)
            j += 1
        return res
                