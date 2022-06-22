class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        q = nums[:k]
        heapq.heapify(q)
        for num in nums[k:]:
            heapq.heappushpop(q, num)
        return q[0]
        
        