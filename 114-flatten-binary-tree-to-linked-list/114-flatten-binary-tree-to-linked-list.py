# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root == None:
            return 
        self.flatten(root.left)
        self.flatten(root.right)
        temp = root.left
        while temp and temp.right:
            temp = temp.right
        if temp:
            temp.right = root.right
            root.right = root.left
        root.left = None
            
        