class Solution {
public:

    struct hashFunction
    {
    size_t operator()(const pair<int , 
                        int> &x) const
    {
        return x.first ^ x.second;
    }
    };

    bool isSafe(int i,int j,int n,int m)
    {
        if(i>=0 && i<n && j>=0 && j<m) return true;
        else return false;
    }

    void dfs(vector<vector<int>>& heights,int n,int m,vector<vector<bool>>& vis,unordered_set<pair<int,int>,hashFunction>& s,int i,int j,vector<vector<int>>& ans) {
        vis[i][j]=true;
        if(s.find({i,j})!=s.end())
        {
            vector<int> v;
            v.push_back(i);
            v.push_back(j);
            ans.push_back(v);
        } 
        else s.insert({i,j});
        int val=heights[i][j];

        if(isSafe(i+1,j,n,m) && !vis[i+1][j] && heights[i+1][j]>=val) dfs(heights,n,m,vis,s,i+1,j,ans);
        if(isSafe(i-1,j,n,m) && !vis[i-1][j] && heights[i-1][j]>=val) dfs(heights,n,m,vis,s,i-1,j,ans);
        if(isSafe(i,j+1,n,m) && !vis[i][j+1] && heights[i][j+1]>=val) dfs(heights,n,m,vis,s,i,j+1,ans);
        if(isSafe(i,j-1,n,m) && !vis[i][j-1] && heights[i][j-1]>=val) dfs(heights,n,m,vis,s,i,j-1,ans);

    }

    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        //For pacific
        //dfs from edges (2 for each ocean)
        //mark visited
        //check neighbors -  if not visited
        //then check if greater or equal to current
        //then call dfs on them in turn
        //store all in un unordered_map

        //do the same for atlantis but if a position is in map -> add to answer

        //for pacific

        int n=heights.size();
        int m=heights[0].size();

        vector<vector<bool>> vis(n,vector<bool>(m,false));

        vector<vector<int>> ans;

        unordered_set<pair<int,int>,hashFunction> s;

        for(int i=0;i<n;i++)
        {
            if(!vis[i][0]) dfs(heights,n,m,vis,s,i,0,ans);
        }

        for(int j=1;j<m;j++)
        {
            if(!vis[0][j]) dfs(heights,n,m,vis,s,0,j,ans);
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) vis[i][j]=false;
        }

        //for atlatic
        for(int i=0;i<n;i++)
        {
            if(!vis[i][m-1]) dfs(heights,n,m,vis,s,i,m-1,ans);
        }

        for(int j=0;j<m-1;j++)
        {
            if(!vis[n-1][j]) dfs(heights,n,m,vis,s,n-1,j,ans);
        }

        return ans;

    }
};