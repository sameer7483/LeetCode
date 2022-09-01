# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodesUtil(self, root, max_val):
        if root == None:
            return 0
        res = 1 if root.val >= max_val else 0
        max_val = max(root.val, max_val)
        left = self.goodNodesUtil(root.left, max_val)
        right = self.goodNodesUtil(root.right, max_val)
        res += left + right
        return res
    def goodNodes(self, root: TreeNode) -> int:
        return self.goodNodesUtil(root, -10004)
        