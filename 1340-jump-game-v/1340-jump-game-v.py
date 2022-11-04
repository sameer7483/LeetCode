class Solution:
    def maxJumps(self, arr: List[int], d: int) -> int:
        @lru_cache(None)
        def util(curr):
            res = 1
            for i in range(curr+1, curr+d+1):
                if i >= len(arr) or arr[i] >= arr[curr]:
                    break
                res = max(res, 1+util(i))
            for i in range(curr-1, curr-d-1, -1):
                if i < 0 or arr[i] >= arr[curr]:
                    break
                res = max(res, 1+util(i))            
            return res
        ans = 1
        for i in range(len(arr)):
            inter = util(i)
            ans = max(ans, inter)
        return ans
        
        