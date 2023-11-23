class Solution:
    def findMin(self, nums: List[int]) -> int:
        lo = 0
        hi = len(nums)-1
        if nums[0] < nums[hi]:
            return nums[0]
        while lo < hi:
            mid = lo + (hi-lo)//2
            if nums[mid] >= nums[0]:
                lo = mid+1
            else:
                hi = mid
        return nums[lo]
            
        
        