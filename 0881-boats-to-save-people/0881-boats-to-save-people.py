class Solution:
    def numRescueBoats(self, p: List[int], limit: int) -> int:
        p.sort()
        i, j = 0 , len(p)-1
        count = 0
        while i <= j:
            if p[j]+p[i] <= limit:
                i += 1
                j -= 1
            else:
                j -= 1
            count += 1
        return count
                
            
        