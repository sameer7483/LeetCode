class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key = lambda x: x[1])
        res = 1
        j = 1
        i = 0
        while j < len(points):
            if points[j][0] <= points[i][1]:
                j += 1
                continue
            res += 1
            i = j
        return res
            