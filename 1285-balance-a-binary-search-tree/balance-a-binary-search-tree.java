/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public void inorder(TreeNode node,ArrayList<Integer> order){
        if(node==null) return;
        inorder(node.left,order);
        order.add(node.val);
        inorder(node.right,order);
    }

    public TreeNode constructTree(ArrayList<Integer> order, int l,int r){
        if(l>r) return null;
        int m = l + (r-l)/2;
        TreeNode newNode = new TreeNode(order.get(m));
        newNode.left = constructTree(order,l,m-1);
        newNode.right = constructTree(order,m+1,r);
        return newNode;
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> order = new ArrayList<>();
        inorder(root,order);
        int n = order.size();
        TreeNode ans = constructTree(order,0,n-1);
        return ans;
    }
}