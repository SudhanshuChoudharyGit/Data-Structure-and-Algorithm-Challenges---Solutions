class Solution {
public:


    // bool isSafe(int i,int j,int m,int n)
    // {
    //     if(i>=0 && i<m && j>=0 && j<n) return true;
    //     else return false;
    // }

    // void dfs(vector<vector<char>>& grid,vector<vector<bool>>& vis,int i,int j)
    // {
    //     vis[i][j]=true;

    //     if(isSafe(i,j-1,grid.size(),grid[0].size()) && grid[i][j-1]=='1' && !vis[i][j-1])
    //     dfs(grid,vis,i,j-1);
    //     if(isSafe(i-1,j,grid.size(),grid[0].size()) && grid[i-1][j]=='1' && !vis[i-1][j])
    //     dfs(grid,vis,i-1,j);
    //     if(isSafe(i,j+1,grid.size(),grid[0].size()) && grid[i][j+1]=='1' && !vis[i][j+1])
    //     dfs(grid,vis,i,j+1);
    //     if(isSafe(i+1,j,grid.size(),grid[0].size()) && grid[i+1][j]=='1' && !vis[i+1][j])
    //     dfs(grid,vis,i+1,j);
        
    // }

    // vector<pair<int,int>> getNeighbors(vector<vector<char>>& grid,int r,int c){
    //     vector<pair<int,int>> neighbors;
    //     int del_row[4]={-1,0,0,1};
    //     int del_col[4]={0,-1,1,0};
    //     for(int i=0;i<4;i++)
    //     {
    //         int row= r+del_row[i];
    //         int col= c+del_col[i];
    //         if(row>=0 && col>=0 && row<grid.size() && col<grid[0].size())
    //         {
    //             neighbors.push_back({row,col});
    //         }
    //     }
    //     return neighbors;
    // }

    // void bfs(vector<vector<char>>& grid,vector<vector<bool>>& vis,int i,int j) {
    //     queue<pair<int,int>> q;
    //     q.push({i,j});
    //     vis[i][j]=true;
    //     while(!q.empty())
    //     {
    //         pair<int,int> pa = q.front();
    //         q.pop();
    //         vector<pair<int,int>> neighbors = getNeighbors(grid,pa.first,pa.second);
    //         for(auto p : neighbors)
    //         {
    //             if(!vis[p.first][p.second] && grid[p.first][p.second]=='1')
    //             {
    //                 vis[p.first][p.second]=true;
    //                 q.push(p);
    //             }
    //         }
    //     }
    // }

    void bfs(vector<vector<char>>& grid,vector<vector<bool>>& vis,int i,int j) {
        queue<pair<int,int>> q;
        q.push({i,j});
        vis[i][j]=true;
        vector<vector<int>> coordinates={{-1,0},{0,-1},{0,1},{1,0}};
        while(!q.empty())
        {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            for(int i=0;i<4;i++)
            {
                int xn = x + coordinates[i][0];
                int yn = y + coordinates[i][1];
                if(xn>=0 && yn>=0 && xn<grid.size() && yn<grid[0].size() && !vis[xn][yn] && grid[xn][yn]=='1')
                {
                    q.push({xn,yn});
                    vis[xn][yn]=true;
                }
            }
        }
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
                    bfs(grid,vis,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }





};

