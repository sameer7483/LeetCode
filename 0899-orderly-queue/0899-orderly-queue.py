class Solution:
    def orderlyQueue(self, s: str, k: int) -> str:
        if k > 1:
            return ''.join(sorted(s))
        res = s
        for i in range(len(s)):
            res = min(res, s[i:]+s[0:i])
        return res
            
            
        