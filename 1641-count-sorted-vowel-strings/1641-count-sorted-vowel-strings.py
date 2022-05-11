class Solution:
    def countVowelStrings(self, n):
        dp = [1] * 5
        for i in range(n):
            dp = accumulate(dp)
        return list(dp)[-1]
        