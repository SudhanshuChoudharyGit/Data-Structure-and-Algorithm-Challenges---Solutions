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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(root==NULL) return ans;
        queue<TreeNode*> q;
        q.push(root);
        bool flag=false;
        while(!q.empty())
        {
            int sizeLevel = q.size();
            stack<int> s;
            vector<int> level;
            while(sizeLevel--)
            {
                TreeNode* node = q.front();
                q.pop();
                if(flag) s.push(node->val);
                else level.push_back(node->val);
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            while(!s.empty())
            {
                level.push_back(s.top());
                s.pop();
            }
            flag=!flag;
            ans.push_back(level);
        }
        return ans;
    }
};