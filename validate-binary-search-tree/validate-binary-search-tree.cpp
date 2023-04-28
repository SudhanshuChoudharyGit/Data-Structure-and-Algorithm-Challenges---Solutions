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

    bool validBST(TreeNode* root, long long int l, long long int r) {
        if(root==NULL) return true;
        if(root->val > l && root->val < r)
        {
            return ( validBST(root->left,l,root->val) && validBST(root->right,root->val,r) );
        }
        else return false;
    }

    bool isValidBST(TreeNode* root) {
        long long int l = LLONG_MIN;
        long long int r = LLONG_MAX;
        return validBST(root,l,r);  
    }
};