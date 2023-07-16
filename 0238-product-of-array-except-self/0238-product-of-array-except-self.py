class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        lt = [1]*n
        res = [1] *n
        for i in range(1, n):
            lt[i] = nums[i-1]*lt[i-1]
        rt = 1
        for i in range(n-1, -1, -1):
            res[i] = lt[i] * rt
            rt = rt * nums[i]
        return res
        
            
        