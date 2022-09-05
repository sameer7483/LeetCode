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
    int kthSmallest(TreeNode* root, int k) {
        int i = 0;
        return util(root, k, i);
    }
    int util(TreeNode* root, int k, int &i){
        if(root == nullptr)
            return -1;
        int left = util(root->left, k, i);
        if(left != -1)
            return left;
        i++;
        if(i == k)
            return root->val;
        return util(root->right, k, i);
        
    }
};