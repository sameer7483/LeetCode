class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        m = {}
        i, j = 0, 0
        res = 0
        max_count = 0
        for j in range(len(s)):
            if s[j] in m:
                m[s[j]] += 1
            else:
                m[s[j]] = 1
            max_count = max(max_count, m[s[j]])
            while i < j and max_count+k < j-i+1 :
                m[s[i]] -= 1
                i +=1
            res = max(res, j-i+1)
        return res
        
        