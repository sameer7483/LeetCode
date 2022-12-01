class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        ct = 0
        vowels = set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'])
        for c in s[:len(s)//2]:
            if c in vowels:
                ct += 1
        for c in s[len(s)//2:]:
            if c in vowels:
                ct -= 1
        return ct == 0
            
        