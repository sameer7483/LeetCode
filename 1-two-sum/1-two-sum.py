class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res=[]
        m = {}
        for i, val in enumerate(nums):
            if target-val in m:
                res.append(i)
                res.append(m[target-val])
                return res
            else:
                m[val] = i     
        return res
            
        