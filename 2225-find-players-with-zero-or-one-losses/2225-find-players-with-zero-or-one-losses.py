class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        m = defaultdict(int)
        res = [[] for i in range(2)]
        for w, l in matches:
            m[l] += 1
            m[w] += 0
        for p, l in m.items():
            if l == 0:
                res[0].append(p)
            if l == 1:
                res[1].append(p)
        res[0].sort()
        res[1].sort()
        return res
            
        