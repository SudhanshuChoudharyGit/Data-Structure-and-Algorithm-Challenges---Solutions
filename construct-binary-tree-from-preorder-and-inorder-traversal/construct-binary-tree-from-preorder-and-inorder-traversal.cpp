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

    int index=0;

    TreeNode* fun(map<int,int>& mp,vector<int>& preorder, vector<int>& inorder,int l,int r,int n){
        if(index>=n) return NULL;
        TreeNode* node= new TreeNode(preorder[index]);
        int m = mp[preorder[index]];
        index++;
        if(l<m) node->left=fun(mp,preorder,inorder,l,m-1,n);
        if(m<r) node->right=fun(mp,preorder,inorder,m+1,r,n);
        return node;
    }


    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        map<int,int> mp;
        for(int i=0;i<inorder.size();i++) mp[inorder[i]]=i;
        return fun(mp,preorder,inorder,0,inorder.size()-1,preorder.size());
    }
























    /*int index=0;

    TreeNode* fun(vector<int>& preorder, vector<int>& inorder, unordered_map<int,int>& mp,int l,int r,int n)
    {
        if(l>r || l<0 || r>n-1 || index>n-1) return NULL;
        TreeNode* node= new TreeNode(preorder[index]);
        int x=mp[preorder[index]];
        index++;
        node->left=fun(preorder,inorder,mp,l,x-1,n);
        node->right=fun(preorder,inorder,mp,x+1,r,n);
        return node;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int,int> mp;
        int n=preorder.size();
        for(int i=0;i<n;i++)
        {
            mp[inorder[i]]=i;
        }
        return fun(preorder,inorder,mp,0,n-1,n);
        
    }

*/
};