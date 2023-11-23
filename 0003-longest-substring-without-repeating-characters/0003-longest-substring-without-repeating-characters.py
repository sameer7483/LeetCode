class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        m = {}
        i = 0
        res = 0
        for j in range(len(s)):
            if s[j] in m:
                 m[s[j]] += 1
            else:
                m[s[j]] = 1
            while j-i+1 > len(m):
                m[s[i]] -= 1
                if m[s[i]] == 0:
                    m.pop(s[i])
                i += 1
            res = max(res, j-i+1)
        return res
        