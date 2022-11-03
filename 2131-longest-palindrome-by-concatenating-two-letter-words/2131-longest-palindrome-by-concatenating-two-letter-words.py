class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        m = defaultdict(int)
        res = 0
        unpaired = 0
        for word in words:
            if word[0] != word[1]:
                if m[word[::-1]] > 0:
                    res += 4
                    m[word[::-1]] -=1
                else:
                    m[word] += 1
            else:
                if m[word] > 0:
                    res += 4
                    unpaired -=1
                    m[word] -= 1
                else:
                    m[word] += 1
                    unpaired +=1
        return res+2 if unpaired > 0 else res
                
                
                
                
        