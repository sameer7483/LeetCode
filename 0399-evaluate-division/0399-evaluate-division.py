class Solution:
    def calcEquation(self, eq: List[List[str]], val: List[float], q: List[List[str]]) -> List[float]:
        adj = defaultdict(list)
        for i in range(len(eq)):
            adj[eq[i][0]].append((eq[i][1], val[i]))
            adj[eq[i][1]].append((eq[i][0], 1/val[i]))
            
        def dfs(curr, end, res, vis): 
            if curr == end:
                return res
            vis.add(curr)
            for v, w in adj[curr]:
                if v not in vis:
                    ans = dfs(v, end, res * w, vis)
                    if ans != -1:
                        return ans
            return -1.0
        res = []
        for u, v in q:
            
            res.append(dfs(u, v, 1.0, set()) if u in adj else -1.0)
        return res
            
        
            
        