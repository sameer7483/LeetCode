class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        n = len(cardPoints)
        win = n-k
        total = sum(cardPoints)
        if win == 0 :
            return total        
        j = 0
        i = 0
        curr = 0
        minSum = total
        while j < n:
            curr += cardPoints[j]
            while i < j and j-i+1 > win:
                curr -= cardPoints[i]
                i += 1
            if j-i+1 == win :
                minSum = min(minSum, curr)
            j += 1
        return total - minSum
            
        