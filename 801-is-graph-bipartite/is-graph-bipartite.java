class Solution {
    //not visited = 0
    //visited group 1 = -1; //false
    //visited group 2 = 1;  //true

    /*
    public boolean dfs(int[][] graph,int i,int[] vis,boolean group){
        vis[i] = (group==true)? -1 : 1;
        for(int n : graph[i])
        {
            if(vis[n]==0)
            {
                if(!dfs(graph,n,vis,!group)) return false;
            } 
            else if(vis[n]==vis[i]) return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0 && !dfs(graph,i,vis,true)) return false;
        }
        return true;   
    }
    */


    //bfs
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];

        for(int i=0;i<n;i++)
        {
            if(vis[i]!=0) continue;
            vis[i]=-1;
            Deque<Integer> q = new ArrayDeque<>();
            q.addLast(i);
            while(q.size()>0)
            {
                    int node = q.removeFirst();
                    for(int neighbour : graph[node])
                    {
                        if(vis[neighbour]==0) 
                        {
                            vis[neighbour] = (vis[node]==-1)?1:-1;
                            q.addLast(neighbour);
                        }
                        else if(vis[neighbour]==vis[node]) return false;
                    }
            } 
        }
         
        return true; 
    }
}