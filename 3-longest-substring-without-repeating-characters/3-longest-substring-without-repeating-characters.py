class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        i = 0
        j = 0
        res = 0
        m = dict()
        while j < n:
            if s[j] in m:
                m[s[j]] = m[s[j]]+1
            else:
                m[s[j]] =1
            while i < j and j-i+1 > len(m):
                if s[i] in m:
                    if m[s[i]] == 1:
                        m.pop(s[i])
                    else:
                        m[s[i]] = m[s[i]]-1
                i = i+1
            res = max(res, j-i+1)
            j =j+1
        return res
            
        