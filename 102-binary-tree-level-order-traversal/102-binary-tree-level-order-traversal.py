# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        q = []
        q.append(root)
        res = []
        while len(q) > 0:
            n = len(q)
            ins = []
            for i in range(n):
                ins.append(q[0].val)
                if q[0].left:
                    q.append(q[0].left)
                if q[0].right:
                    q.append(q[0].right)
                q.pop(0)
            res.append(ins)
        return res
                
                
                
        