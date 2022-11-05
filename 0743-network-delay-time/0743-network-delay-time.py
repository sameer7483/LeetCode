class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj_list = defaultdict(list)
        for u, v, w in times:
            adj_list[u].append((w, v))
        pq = adj_list[k]
        vis = set()
        vis.add(k)
        heapq.heapify(pq)
        while len(pq) > 0:
            p = heapq.heappop(pq)
            vis.add(p[1])
            if len(vis) == n:
                return p[0]
            for w, v in adj_list[p[1]]:
                if v not in vis:
                    heapq.heappush(pq, (w+p[0], v))
        return -1
            
            
        