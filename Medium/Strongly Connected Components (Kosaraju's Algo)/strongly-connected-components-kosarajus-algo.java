//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int i,boolean[] vis,Deque<Integer> dq) {
        vis[i] = true;
        for(int n : adj.get(i))
        {
            if(!vis[n]) dfs(adj,n,vis,dq);
        }
        dq.addLast(i);
    }
    
    public void dfs2(ArrayList<ArrayList<Integer>> adj, int i,boolean[] vis) {
        vis[i] = true;
        for(int n : adj.get(i))
        {
            if(!vis[n]) dfs2(adj,n,vis);
        }
    }
    
    public ArrayList<ArrayList<Integer>> reverseList(ArrayList<ArrayList<Integer>> adj,int V) {
        ArrayList<ArrayList<Integer>> revList = new ArrayList<>();
        for(int i=0;i<V;i++) revList.add(new ArrayList<Integer>());
        for(int i=0;i<V;i++)
        {
            for(int node : adj.get(i))
            {
                revList.get(node).add(i);
            }
        }
        return revList;
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i]) dfs(adj,i,vis,dq);
        }
        
        ArrayList<ArrayList<Integer>> rev = reverseList(adj,V);
        Arrays.fill(vis,false);
        int ans = 0;
        while(dq.size()>0)
        {
            int node = dq.removeLast();
            if(!vis[node])
            {
                dfs2(rev, node, vis);
                ans++;
            }
        }
        
        return ans;
    }
}
