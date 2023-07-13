class Solution:
    def canFinish(self, numCourses: int, prereq: List[List[int]]) -> bool:
        adj = defaultdict(list)
        for u, v in prereq:
            adj[v].append(u)
        def has_cycle(u, vis, rec_vis):
            nonlocal adj
            if u in rec_vis:
                return True
            if u in vis:
                return False
            vis.add(u)
            rec_vis.add(u)
            for v in adj[u]:
                if(has_cycle(v, vis, rec_vis)):
                    return True
            rec_vis.remove(u)
            return False
        vis = set()
        for i in range(numCourses):
            if(has_cycle(i, vis, set())):
                return False
        return len(vis) == numCourses
        
            
            
        