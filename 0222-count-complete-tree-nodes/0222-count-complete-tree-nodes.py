# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        left = root.left
        left_height = 0
        while left != None:
            left = left.left
            left_height += 1
        right = root.right
        right_height = 0
        while right != None:
            right = right.right
            right_height += 1
        if right_height == left_height:
            return 2**(right_height+1) -1
        else:
            return 1 + self.countNodes(root.left) + self.countNodes(root.right)
        
        