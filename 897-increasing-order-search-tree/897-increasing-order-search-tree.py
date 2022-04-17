# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        if root == None:
            return root
        left = self.increasingBST(root.left)
        right = self.increasingBST(root.right)
        if(left == None):
            root.right = right
            return root
        temp = left
        while(temp != None and temp.right != None):
            temp = temp.right
        root.left = None
        root.right = right
        temp.right = root
        return left
        