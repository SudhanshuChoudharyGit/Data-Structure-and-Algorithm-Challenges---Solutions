//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class Solution {
    
    class Pair{
    int x;
    int y;
    
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
    }
    // Function to find the number of islands.
    
    Pair[] getNeighbours(int i,int j){
        Pair[] neighbours = new Pair[8];
        neighbours[0] = new Pair(i-1,j-1);
        neighbours[1] = new Pair(i-1,j);
        neighbours[2] = new Pair(i-1,j+1);
        neighbours[3] = new Pair(i,j-1);
        neighbours[4] = new Pair(i,j+1);
        neighbours[5] = new Pair(i+1,j-1);
        neighbours[6] = new Pair(i+1,j);
        neighbours[7] = new Pair(i+1,j+1);
        return neighbours;
    }
    
    
    boolean isSafe(int i,int j,int m,int n)
    {
        if(i>=0 && i<m && j>=0 && j<n) return true;
        return false;
    }
    
    void dfs(char[][] grid, int i, int j,boolean[][] vis,int m,int n){
        vis[i][j] = true;
        for(Pair p : getNeighbours(i,j))
        {
            int x = p.x;
            int y = p.y;
            if(isSafe(x,y,m,n) && !vis[x][y] && grid[x][y]=='1')
            {
                dfs(grid,x,y,vis,m,n);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!vis[i][j] && grid[i][j]=='1')
                {
                    dfs(grid,i,j,vis,m,n);
                    count++;
                }
            }
        }
        return count;
    }
}