# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.curr = 0
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root == None:
            return -1
        left = self.kthSmallest(root.left, k)
        if left != -1:
            return left
        self.curr +=1
        if(self.curr == k):
            return root.val
        return self.kthSmallest(root.right,k)
        
        