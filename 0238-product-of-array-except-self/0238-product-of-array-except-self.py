class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        lt = [1]*n
        rt = [1]*n
        res = [1] *n
        for i in range(1, n):
            lt[i] = nums[i-1]*lt[i-1]
        for i in range(n-2, -1, -1):
            rt[i] = nums[i+1] * rt[i+1]
        for i in range(n):
            res[i] = lt[i] * rt[i]
        return res
        
            
        