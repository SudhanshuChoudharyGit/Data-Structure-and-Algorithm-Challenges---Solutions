class Solution {
public:

    bool isValid(vector<vector<int>>& image,int r, int c) {
        if(r>=0 && c>=0 && r<image.size() && c<image[0].size()) return true;
        return false;
    }

    void dfs(vector<vector<int>>& image,int r, int c, int source, int color,vector<vector<bool>>& vis) {
        vis[r][c]=true;
        image[r][c]=color;
        int del_row[4]={-1,0,0,1};
        int del_col[4]={0,-1,1,0};
        for(int i=0;i<4;i++)
        {
            int row = r+del_row[i];
            int col = c+del_col[i];

            if(isValid(image,row,col) && !vis[row][col] && image[row][col]==source)
            {
                dfs(image,row,col,source,color,vis);
            }
        }
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        vector<vector<bool>> vis(image.size(),vector<bool>(image[0].size(),false));
        dfs(image,sr,sc,image[sr][sc],color,vis);
        return image;
    }
};