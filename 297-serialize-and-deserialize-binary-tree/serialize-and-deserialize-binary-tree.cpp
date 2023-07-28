/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if(!root) return("N");
        return to_string(root->val)+","+serialize(root->left)+","+serialize(root->right);
    }

    TreeNode* deserialize(stringstream& s)
    {
        string str;
        getline(s,str,',');
        TreeNode* node=NULL;
        if(str!="N")
        {
            node= new TreeNode(stoi(str));
            node->left = deserialize(s);
            node->right = deserialize(s);
        }
        return node;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        stringstream s(data);
        return deserialize(s);
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));