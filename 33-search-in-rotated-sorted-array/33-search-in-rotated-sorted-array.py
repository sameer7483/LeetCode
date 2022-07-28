class Solution:
    def pivot(self, nums: List[int]):
        lo = 0
        hi = len(nums)-1
        while lo < hi:
            mid = lo + (hi-lo)//2
            if nums[0] > nums[mid]:
                hi = mid
            else:
                lo = mid+1
        return lo
    def bs(self, nums: List[int],lo:int, hi:int, target:int):
        while lo < hi:
            mid = lo + (hi-lo)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                hi = mid
            else:
                lo = mid + 1
        return lo
            
        
    def search(self, nums: List[int], target: int) -> int:
        piv = self.pivot(nums)
        if(nums[piv] == target):
            return piv
        idx = self.bs(nums, 0, piv-1, target)
        if nums[idx] == target:
            return idx
        else:
            idx = self.bs(nums, piv, len(nums)-1, target)
        if nums[idx] == target:
            return idx
        else:
            return -1
        
        
        
        