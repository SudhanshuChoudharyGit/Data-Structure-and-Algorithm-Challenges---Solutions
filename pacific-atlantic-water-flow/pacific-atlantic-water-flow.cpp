class Solution {
public:

    bool isSafe(int i,int j,int n,int m)
    {
        if(i>=0 && i<n && j>=0 && j<m) return true;
        else return false;
    }

    void dfs(vector<vector<int>>& heights,int n,int m,vector<vector<bool>>& vis,int i,int j) {
        
        vis[i][j]=true;

        int val=heights[i][j];

        if(isSafe(i+1,j,n,m) && !vis[i+1][j] && heights[i+1][j]>=val) dfs(heights,n,m,vis,i+1,j);
        if(isSafe(i-1,j,n,m) && !vis[i-1][j] && heights[i-1][j]>=val) dfs(heights,n,m,vis,i-1,j);
        if(isSafe(i,j+1,n,m) && !vis[i][j+1] && heights[i][j+1]>=val) dfs(heights,n,m,vis,i,j+1);
        if(isSafe(i,j-1,n,m) && !vis[i][j-1] && heights[i][j-1]>=val) dfs(heights,n,m,vis,i,j-1);

    }

    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        //do dfs from edges of both atlantic and pacific
        //have a diff vis 2D array for for of them: keeps track of elements which can send water to them respectively
        //finally for the indexes for which both vis array and true are the answer


        int n=heights.size();
        int m=heights[0].size();

        vector<vector<bool>> pacific(n,vector<bool>(m,false));
        vector<vector<bool>> atlantic(n,vector<bool>(m,false));

        vector<vector<int>> ans;


        for(int i=0;i<n;i++)
        {
            dfs(heights,n,m,pacific,i,0);
            dfs(heights,n,m,atlantic,i,m-1);
        }

        for(int j=0;j<m;j++)
        {
            dfs(heights,n,m,pacific,0,j);
            dfs(heights,n,m,atlantic,n-1,j);
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(pacific[i][j] && atlantic[i][j]) ans.push_back({i,j});
            }
        }

        return ans;

    }
};