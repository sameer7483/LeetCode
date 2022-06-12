class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        i=0
        j=0
        curr_sum=0
        res = 0
        m = {}
        while j < len(nums):
            if nums[j] in m:
                m[nums[j]] += 1
            else:
                m[nums[j]] = 1
            curr_sum += nums[j]
            while i < j and j-i+1 > len(m):
                curr_sum -= nums[i]
                m[nums[i]] -=1
                if m[nums[i]] == 0:
                    m.pop(nums[i])
                i +=1
            res = max(res, curr_sum)
            j +=1
        return res
                
            
        