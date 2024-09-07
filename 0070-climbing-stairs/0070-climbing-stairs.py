class Solution:
    def climbStairs(self, n: int) -> int:
        m = [-1] * (n+1)
        def recurse(n):
            if n==1:
                return 1
            if n==2:
                return 2
            if m[n] != -1:
                return m[n]
            m[n] = recurse(n-1) + recurse(n-2)
            return m[n]
        return recurse(n)
        