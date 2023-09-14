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

    public TreeNode fun(TreeNode root,List<TreeNode> ans,Set<Integer> deleteIt)
    {
        if(root==null) return root;
        if(deleteIt.contains(root.val))
        {
            if(fun(root.left,ans,deleteIt)!=null) ans.add(root.left);
            if(fun(root.right,ans,deleteIt)!=null) ans.add(root.right);
            return null;
        }
        root.left = fun(root.left,ans,deleteIt);
        root.right = fun(root.right,ans,deleteIt);
        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteIt = new HashSet<>();
        for(int x : to_delete) deleteIt.add(x);
        List<TreeNode> ans = new ArrayList<>();
        if(fun(root,ans,deleteIt)!=null) ans.add(root);
        return ans;
    }


























    /*
    public void dfs(TreeNode root,HashMap<TreeNode,Integer> map)
    {
        if(root==null) return;
        map.put(root,1);
        if(root.left!=null){
        if(map.get(root.left)==-1) root.left=null;
        else dfs(root.left,map);
        }
        if(root.right!=null){
        if(map.get(root.right)==-1) root.right=null;
        else dfs(root.right,map);
        }
    }

    public void preorder(TreeNode root,HashMap<TreeNode,Integer> map,Set<Integer> st) {
        if(root==null) return;
        map.put(root,0);
        if(st.contains(root.val)) map.put(root,-1);
        preorder(root.left,map,st);
        preorder(root.right,map,st);
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<TreeNode,Integer> map = new LinkedHashMap<>();
        Set<Integer> st = new HashSet<>();
        for(int x : to_delete) st.add(x);
        preorder(root,map,st);
        //not visited = 0
        //visited = 1
        //delete = -1
        for(var entry : map.entrySet())
        {
            if(entry.getValue()==0) 
            {
                ans.add(entry.getKey());
                dfs(entry.getKey(),map);
            }
        }
        return ans;

    }
    */
}