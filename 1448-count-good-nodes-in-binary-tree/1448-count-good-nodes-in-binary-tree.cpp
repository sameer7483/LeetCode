/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int goodNodes(TreeNode* root) {
        return goodNodesUtil(root, INT_MIN);
    }
    int goodNodesUtil(TreeNode* root, int max_val) {
        if(root == nullptr)
            return 0;
        int res = (root->val >= max_val ? 1 : 0);
        max_val = max(max_val, root->val);        
        int left = goodNodesUtil(root->left, max_val);
        int right = goodNodesUtil(root->right, max_val);
        res += left + right;
        return res;
    }  
};