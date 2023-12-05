class Solution:
    def minMutation(self, s: str, e: str, bank: List[str]) -> int:
        bank = set(bank)
        q = []
        q.append(s)
        res = 0
        vis = set()
        while len(q) > 0:
            size = len(q)
            for i in range(size):
                p = q.pop(0)
                vis.add(p)
                if p == e:
                    return res  
                for i in range(len(p)):
                    for c in ['A', 'C', 'G', 'T']:
                        new_p = p[:i] + c + p[i+1:]
                        if new_p in bank and new_p not in vis:
                            q.append(new_p)
            res += 1
        return -1

                
        