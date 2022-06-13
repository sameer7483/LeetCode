class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum = -float('inf')
        curr_max = 0
        for num in nums:
            curr_max += num
            max_sum = max(curr_max, max_sum)
            if curr_max < 0:
                curr_max = 0
        return max_sum
            
            
        