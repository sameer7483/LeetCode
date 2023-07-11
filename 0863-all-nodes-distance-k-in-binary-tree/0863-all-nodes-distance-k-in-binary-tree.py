# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import defaultdict
class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        adj = defaultdict(list)
        if k==0:
            return [target.val]
        def create_graph(curr):
            nonlocal adj
            if curr == None:
                return
            if curr.left:
                adj[curr.val].append(curr.left)
                adj[curr.left.val].append(curr)
            if curr.right:
                adj[curr.val].append(curr.right)
                adj[curr.right.val].append(curr)
            create_graph(curr.left)
            create_graph(curr.right)
        create_graph(root)
        q = deque()
        q.append(target)
        res = []
        dist = [-1]*505
        dist[target.val] = 0
        while len(q) > 0:
            p = q.popleft()
            for v in adj[p.val]:
                if dist[v.val] == -1:
                    dist[v.val] = 1+dist[p.val]
                    q.append(v)
                    if dist[v.val] == k:
                        res.append(v.val)
        return res
            
            
                
        