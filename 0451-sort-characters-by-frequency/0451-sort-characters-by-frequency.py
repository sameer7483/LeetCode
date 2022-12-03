class Solution:
    def frequencySort(self, s: str) -> str:
        m = Counter(s)
        q = []
        for k, v in m.items():
            heapq.heappush(q, (-v, k))
        res = []
        while len(q) > 0:
            for i in range(-(q[0][0])):
                res.append(q[0][1])
            heapq.heappop(q)
        return ''.join(res)
        
            
        