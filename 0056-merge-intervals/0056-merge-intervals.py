class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        intervals.sort(key = lambda x : (x[0], x[1]))
        n = len(intervals)
        i, j = 0, 1
        while i < n:
            end = intervals[i][1]
            while j < n and intervals[j][0] <= end:
                end = max(end, intervals[j][1])
                j += 1
            res.append([intervals[i][0], end])
            i = j
        return res
                
                
        