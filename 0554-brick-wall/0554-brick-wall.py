class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        m = defaultdict(int)
        width = 0
        for i in range(len(wall)):
            edge = 0
            for j in range(len(wall[i])-1):
                edge += wall[i][j]
                m[edge] += 1
        return len(wall) - max(m.values()) if len(m) > 0 else len(wall)
                
                
        