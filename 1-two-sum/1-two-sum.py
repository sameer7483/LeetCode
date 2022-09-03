class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res = []
        m = {}
        for i, num in enumerate(nums):
            if target-num in m:
                return [i, m[target-num]]
            else:
                m[num] = i
            
        