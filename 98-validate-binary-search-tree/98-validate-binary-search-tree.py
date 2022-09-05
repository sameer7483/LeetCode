# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def validateBST(self, root, min_val, max_val):
        if root == None:
            return True
        return root.val > min_val and root.val < max_val and self.validateBST(root.left, min_val, root.val) and self.validateBST(root.right, root.val, max_val)
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.validateBST(root, -2147483649, 2147483648)
        
        