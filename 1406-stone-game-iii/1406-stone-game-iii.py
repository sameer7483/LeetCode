class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        @lru_cache(maxsize=None)
        def minmax(curr, isAlice):
            if curr >= len(stoneValue):
                return 0
            res = 0
            ans = -100001
            if isAlice:
                for i in range(curr, curr+3):
                    if i >= len(stoneValue):
                        continue
                    res += stoneValue[i] 
                    ans = max(ans, res + minmax(i+1, not isAlice))
                return ans
            else:
                return min([minmax(i+1, not isAlice) for i in range(curr, curr+3)])
        total = sum(stoneValue)
        val = minmax(0, True)
        if total - val > val:
            return "Bob"
        elif total - val < val:
            return "Alice"
        else:
            return "Tie"
            
            
                
        