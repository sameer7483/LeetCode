class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        target = collections.Counter(s1)
        count = {}
        i, j = 0, 0
        curr = 0
        for j in range(len(s2)):
            count[s2[j]] = count.get(s2[j], 0) +1
            if j-i+1 < len(s1):
                j += 1
            else:
                if target == count:
                    return True
                count[s2[i]] -=1
                if count[s2[i]] == 0:
                    count.pop(s2[i])
                i += 1
        return False
            

            
            
        