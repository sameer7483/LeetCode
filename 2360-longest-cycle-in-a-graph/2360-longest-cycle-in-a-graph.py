class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        vis_time = [0] * len(edges)
        time = 1
        res = -1
        for i in range(len(edges)):
            if vis_time[i] > 0:
                continue
            start_time = time
            vis_time[i] = time
            time += 1
            u = edges[i]
            while u != -1 and vis_time[u] == 0:
                vis_time[u] = time
                time += 1
                u = edges[u]
            if u != -1 and vis_time[u] >= start_time:
                res = max(res, time - vis_time[u])
        return res
            
            
        