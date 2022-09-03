class Solution:
    def dfs(self, num, n, k, res):
        if n == 0:
            res.append(num)
            return
        unit = num % 10
        if unit + k <= 9:
            self.dfs(num*10 + unit + k, n-1, k, res)
        if k != 0 and unit >= k:
            self.dfs(num*10 + unit - k, n-1, k, res)
            
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        res = []
        for i in range(1, 10):
            self.dfs(i, n-1, k, res)
        return res
        