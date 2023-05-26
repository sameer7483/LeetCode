class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        @lru_cache(maxsize=None)
        def minmax(curr, m, alice):
            if curr >= len(piles):
                return 0
            if alice:
                return max([sum(piles[curr:curr+i])+minmax(curr+i, max(m, i), not alice) for i in range(1, 2*m+1)])
            else:
                return min([minmax(curr+i, max(m, i), not alice) for i in range(1, 2*m+1)])
        return minmax(0, 1, True)
        