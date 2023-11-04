class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        //bfs
        boolean[] vis = new boolean[n];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(source);
        vis[source] = true;
        while(!dq.isEmpty())
        {
            int node = dq.removeFirst();
            if(node==destination) return true;
            for(int nb : adj.get(node))
            {
                if(vis[nb]==false)
                {
                    vis[nb] = true;
                    dq.addLast(nb);
                }
            }
        }

        return false;
    }
}