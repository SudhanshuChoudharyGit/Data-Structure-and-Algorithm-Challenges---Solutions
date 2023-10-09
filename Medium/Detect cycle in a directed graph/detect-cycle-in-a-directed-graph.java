//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    public boolean cyclePresent(ArrayList<ArrayList<Integer>> adj,int i,boolean[] vis,boolean[] pathvis){
        vis[i] = true;
        pathvis[i] = true;
        for(int neighbour : adj.get(i))
        {
            if(!vis[neighbour])
            {
                if(cyclePresent(adj,neighbour,vis,pathvis)) return true;
            }
            else
            {
                if(pathvis[neighbour]==true) return true;
            }
        }
        pathvis[i] = false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] pathvis = new boolean[V];
        for(int i=0;i<V;i++)
        {
          if(!vis[i])
          {
              if(cyclePresent(adj,i,vis,pathvis)==true) return true;
          }
        }
        return false;
    }
}