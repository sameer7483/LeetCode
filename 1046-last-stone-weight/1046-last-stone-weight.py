class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        q = [-x for x in stones]
        heapq.heapify(q)
        while len(q) > 1:
            f = heapq.heappop(q)
            s = heapq.heappop(q)
            if(f != s):
                heapq.heappush(q, f-s)
        return 0 if len(q) == 0 else -q[0]
            
        
            
        