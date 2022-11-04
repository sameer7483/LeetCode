class Solution:
    def numOfWays(self, n: int) -> int:
        a121, a123, mod = 6, 6, 10**9+7
        for i in range(n-1):
            b121 = 3 * a121 + 2*a123
            b123 = 2 * a121 + 2*a123
            a121 = b121%mod
            a123 = b123%mod
        return (a121+a123)%mod
        