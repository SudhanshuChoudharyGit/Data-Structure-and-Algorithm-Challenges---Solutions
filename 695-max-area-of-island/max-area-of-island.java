class Solution {
    int rows;
    int cols;

    public int dfs(int[][] grid,int i,int j,boolean[][] vis){
        if(i>=0 && i<rows && j>=0 && j<cols && vis[i][j]==false && grid[i][j]==1)
        {
            int area = 1;
            vis[i][j] = true;
            area += dfs(grid,i-1,j,vis);
            area += dfs(grid,i,j-1,vis);
            area += dfs(grid,i+1,j,vis);
            area += dfs(grid,i,j+1,vis);
            return area;
        }
        return 0;
    }

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int maxarea = 0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(vis[i][j]==false && grid[i][j]==1)
                {
                    maxarea = Math.max(maxarea,dfs(grid,i,j,vis));
                }
            }
        }
        return maxarea;
    }
}