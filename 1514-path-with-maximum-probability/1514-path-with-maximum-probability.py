class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        adj_list = defaultdict(list)
        for i, e in enumerate(edges):
            adj_list[e[0]].append((e[1], succProb[i]))
            adj_list[e[1]].append((e[0], succProb[i]))
        pq = []
        prob = [0.0]*n
        for i in range(n):
            if i == start:
                pq.append((-1.0, i))
            else:
                pq.append((float('inf'), i))
        prob[start] = 1.0
        heapq.heapify(pq)
        while len(pq) > 0:
            w, p = heapq.heappop(pq)
            if p == end:
                return prob[p]
            for v, wei in adj_list[p]:
                if wei*-w > prob[v]:
                    prob[v] = wei*-w
                    heapq.heappush(pq, (-prob[v], v))
        
        return prob[end]   
        
        
                
                
                
                
        