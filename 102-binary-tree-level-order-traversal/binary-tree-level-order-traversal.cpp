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

    //when you finish popping out a level, at that time, all you have is the next level
    //thus the size of queue at that time is the size of the level
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        queue<TreeNode*> q;
        if(!root) return ans;
        q.push(root);
        while(!q.empty())
        {
            int sizeLevel= q.size();
            vector<int> levelEntries;
            while(sizeLevel--)
            {
                TreeNode* node = q.front();
                q.pop();
                levelEntries.push_back(node->val);
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            ans.push_back(levelEntries);
        }
        return ans;
    }



























    // vector<vector<int>> levelOrder(TreeNode* root) {
    //     vector<vector<int>> ans;
    //     if(root==NULL) return ans;
    //     queue<TreeNode*> q;
    //     q.push(root);
    //     while(!q.empty())
    //     {
    //         q.push(NULL);
    //         vector<int> v;
    //         while(q.front()!=NULL)
    //         {
    //         TreeNode* temp=q.front();
    //         q.pop();
    //         v.push_back(temp->val);
    //         if(temp->left) q.push(temp->left);
    //         if(temp->right) q.push(temp->right);
    //         }
    //         q.pop();
    //         ans.push_back(v);
    //     }
    //     return ans;   
    // }
};