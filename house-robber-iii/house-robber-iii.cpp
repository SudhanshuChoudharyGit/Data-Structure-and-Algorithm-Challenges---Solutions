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

    int helper(TreeNode* node,unordered_map<TreeNode*,int>& mp) {
        if(!node) return 0;
        mp[node]=helper(node->left,mp)+helper(node->right,mp);
        int leftvalue=0;
        int rightvalue=0;
        if(node->left!=NULL) leftvalue=mp[node->left];
        if(node->right!=NULL) rightvalue=mp[node->right];
        return max(mp[node],leftvalue+rightvalue+node->val);
    }


    int rob(TreeNode* root) {
        if(!root) return 0;
        unordered_map<TreeNode*,int> mp;
        return helper(root,mp);
    }
};