class Solution {

    int m;
    int n;

    public void dfs(int[][] grid,int i,int j,boolean[][] vis)
    {
        if(i>=0 && i<m && j>=0 && j<n && vis[i][j]==false && grid[i][j]==1)
        {
            vis[i][j] = true;
            dfs(grid,i,j-1,vis);
            dfs(grid,i-1,j,vis);
            dfs(grid,i,j+1,vis);
            dfs(grid,i+1,j,vis);
        }
    }
    
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++) 
        {
            if(vis[i][0]==false && grid[i][0]==1) dfs(grid,i,0,vis);
            if(vis[i][n-1]==false && grid[i][n-1]==1) dfs(grid,i,n-1,vis);
        }
        for(int j=0;j<n;j++) 
        {
            if(vis[0][j]==false && grid[0][j]==1) dfs(grid,0,j,vis);
            if(vis[m-1][j]==false && grid[m-1][j]==1) dfs(grid,m-1,j,vis);
        }

        int count = 0;
        for(int i=1;i<m-1;i++)
        {
            for(int j=1;j<n-1;j++)
            {
                if(vis[i][j]==false && grid[i][j]==1) count++;
            }
        }

        return count;
    }
}