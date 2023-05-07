class Solution:
    def findNext(self, sl, key):
        lo, hi = 0, len(sl)-1
        while lo < hi:
            mid = (lo + hi)//2
            if sl[mid] <= key:
                lo = mid+1
            else:
                hi = mid
        return lo
        
    def longestObstacleCourseAtEachPosition(self, ob: List[int]) -> List[int]:
        sl = []
        res = []
        for i in range(len(ob)):
            idx = 0
            if len(sl) == 0 or ob[i] >= sl[-1]:
                idx = len(sl)
                sl.append(ob[i]);
            else:
                idx = self.findNext(sl, ob[i])
                sl[idx] = ob[i]
            res.append(idx+1)
        return res
                
                
                
        