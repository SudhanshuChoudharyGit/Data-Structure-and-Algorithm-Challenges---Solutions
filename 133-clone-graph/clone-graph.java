/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node dfs(Node node,Map<Integer,Node> mp) {
        if(node==null) return node;
        if(mp.containsKey(node.val)) return mp.get(node.val);
        int currVal = node.val;
        Node currNode = new Node(currVal);
        mp.put(currVal,currNode);
        for(Node n : node.neighbors)
        {
            Node newNeighborNode = dfs(n,mp);
            currNode.neighbors.add(newNeighborNode);
        }
        return currNode;
    }


    public Node cloneGraph(Node node) {
        Map<Integer,Node> mp = new HashMap<>();
        return dfs(node,mp);
    }
}