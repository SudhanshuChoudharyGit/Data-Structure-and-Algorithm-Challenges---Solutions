class Solution {
public:


    bool isSafe(int i,int j,int m,int n)
    {
        if(i>=0 && i<m && j>=0 && j<n) return true;
        else return false;
    }

    void dfs(vector<vector<char>>& grid,vector<vector<bool>>& vis,int i,int j)
    {
        vis[i][j]=true;

        if(isSafe(i,j-1,grid.size(),grid[0].size()) && grid[i][j-1]=='1' && !vis[i][j-1])
        dfs(grid,vis,i,j-1);
        if(isSafe(i-1,j,grid.size(),grid[0].size()) && grid[i-1][j]=='1' && !vis[i-1][j])
        dfs(grid,vis,i-1,j);
        if(isSafe(i,j+1,grid.size(),grid[0].size()) && grid[i][j+1]=='1' && !vis[i][j+1])
        dfs(grid,vis,i,j+1);
        if(isSafe(i+1,j,grid.size(),grid[0].size()) && grid[i+1][j]=='1' && !vis[i+1][j])
        dfs(grid,vis,i+1,j);
        
    }

    int numIslands(vector<vector<char>>& grid) {
        int m=grid.size();
        int n=grid[0].size();
        vector<vector<bool>> vis(m,vector<bool>(n,false));
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1' && !vis[i][j])
                {
                    dfs(grid,vis,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }


};

