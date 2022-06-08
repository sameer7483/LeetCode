class Solution:
    def removePalindromeSub(self, s: str) -> int:
        def isPalindrome(st) -> bool:
            i = 0
            j = len(st)-1
            while i < j : 
                if s[i] != s[j]:
                    return False
                i +=1
                j -=1
            return True
        if isPalindrome(s):
            return 1
        else:
            return 2
        