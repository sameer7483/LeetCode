# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q = []
        res = []
        if root == None:
            return res
        q.append(root)
        while len(q) > 0:
            size = len(q)
            res.append(q[0].val)
            for i in range(size):
                curr = q.pop(0)
                if curr.right:
                    q.append(curr.right)
                if curr.left:
                    q.append(curr.left)
        return res
                
                
            