class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        colors = [-1]*len(graph)
        
        def color(u, c, p):
            nonlocal colors
            if colors[u] != -1 and colors[u] != c:
                return False
            if colors[u] == c:
                return True
            colors[u] = c
            res = True
            for v in graph[u]:
                if v != p:
                    res = res and color(v, not c, u)
            return res
        for i in range(len(colors)):
            if colors[i] == -1:
                if not color(i, 0, -1):
                    return False
        return True
                    
            
        