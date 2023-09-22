class Solution {
    //not visited = 0
    //visited group 1 = -1; //false
    //visited group 2 = 1;  //true

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
}