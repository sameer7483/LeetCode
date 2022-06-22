class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        q = []
        heapq.heapify(q)
        for num in nums:
            if len(q) < k:
                heapq.heappush(q, num)
            elif q[0] < num:
                heapq.heappushpop(q, num)
        return q[0]
        
        