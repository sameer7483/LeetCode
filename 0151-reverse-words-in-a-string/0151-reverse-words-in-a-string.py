class Solution:
    def reverseWords(self, s: str) -> str:
        s = ' '.join(s.split()[::-1])
        return s
        
        