//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int node;
    int parent;
    
    public Pair(int node,int parent){
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    
    
    //BFS
    /*
    public boolean detect(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int x) {
        Deque<Pair> dq = new ArrayDeque<>();
        dq.addLast(new Pair(x,-1));
        vis[x] = true;
        while(dq.size()>0)
        {
            Pair p = dq.removeFirst();
            int currNode = p.node;
            int currParent = p.parent;
            for(int neighbour : adj.get(currNode))
            {
                if(vis[neighbour]==false)
                {
                    vis[neighbour] = true;
                    dq.addLast(new Pair(neighbour,currNode));
                }
                else{
                    if(neighbour!=currParent) return true;
                }
            }
        }
        return false;
    }*/
    
    
    public boolean detect(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int x,int parent) {
        vis[x] = true;
        for(int neighbour : adj.get(x))
        {
            if(vis[neighbour]==false)
            {
                if(detect(adj,vis,neighbour,x)) return true;
            }
            else
            {
                if(neighbour!=parent) return true;
            }
        }
        return false;
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(detect(adj,vis,i,-1)) return true;
            }
        }
        return false;
    }
}