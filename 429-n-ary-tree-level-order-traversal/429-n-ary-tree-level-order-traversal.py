"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        res = []
        if root ==None:
            return res
        q = deque()
        q.append(root)
        while(len(q) > 0):
            size = len(q)
            l = []
            for i in range(size):
                curr = q.popleft()
                l.append(curr.val)
                for child in curr.children:
                    if child:
                        q.append(child)
            res.append(l)
        return res
                
        