class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        adj_list = defaultdict(set)
        for u, v in roads:
            adj_list[u].add(v)
            adj_list[v].add(u)
        res = 0
        for i in range(n):
            for j in range(i+1, n):
                total = len(adj_list[i]) + len(adj_list[j])
                if j in adj_list[i]:
                    total -=1
                res = max(res, total)
        return res
                
        