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

    int helper(TreeNode* root,int& maxpathsum) {
        if(!root) return 0;
        int l=helper(root->left,maxpathsum);
        int r=helper(root->right,maxpathsum);
        int maxreturn = max(root->val,max(root->val+l,root->val+r));
        maxpathsum=max(maxpathsum,max(maxreturn,root->val+l+r));
        return maxreturn;
    }

    int maxPathSum(TreeNode* root) {
        int maxpathsum=INT_MIN;
        helper(root,maxpathsum);
        return maxpathsum;
    }

};



















/*

class Solution {
public:

    int maxval(TreeNode* root,int& ans)
    {
        if(root==NULL) return 0;
        int left=maxval(root->left,ans);
        int right=maxval(root->right,ans);
        int val=max(left,right)+root->val;
        ans=max(ans,max(val,max(root->val,left+right+root->val)));
        return max(val,root->val);
    }

    int maxPathSum(TreeNode* root) {
        int ans=INT_MIN;
        maxval(root,ans);
        return ans;
    }
};

*/