class Solution:
    def makeArrayIncreasing(self, arr1: List[int], arr2: List[int]) -> int:
        arr2.sort()
        @lru_cache(None)
        def minOper(curr, last):
            if curr >= len(arr1):
                return 0
            if arr1[curr] > last:
                res1 = minOper(curr+1, arr1[curr])
            else:
                res1 = float('inf')
            nextBig = bisect.bisect_right(arr2, last)
            if nextBig == len(arr2):
                res2 = float('inf')
            else:
                res2 = minOper(curr+1, arr2[nextBig])
            return min(res1, res2+1)
        res = minOper(0, float('-inf'))
        return res if res != float('inf') else -1
                

        