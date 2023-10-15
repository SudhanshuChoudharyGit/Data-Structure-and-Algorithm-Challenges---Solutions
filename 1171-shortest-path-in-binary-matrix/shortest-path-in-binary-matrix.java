class Pair{
    int x;
    int y;

    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {

    public final int[][] neighbors = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public ArrayList<Pair> getAvailablePairs(Pair p,int[][] grid,boolean[][] vis,int n)
    {
        ArrayList<Pair> ans = new ArrayList<>();
        for(int i=0;i<8;i++)
        {
            int currX = p.x+neighbors[i][0];
            int currY = p.y+neighbors[i][1];
            if(currX>=0 && currX<n && currY>=0 && currY<n && vis[currX][currY]==false && grid[currX][currY]==0)
            {
                ans.add(new Pair(currX,currY));
            }
        }
        return ans;
    }


    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;
        Deque<Pair> dq = new ArrayDeque<>();
        dq.addLast(new Pair(0,0));
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        int len = 1;
        while(dq.size()>0)
        {
            int size = dq.size();
            while(size-- >0)
            {
                Pair curr = dq.removeFirst();
                if(curr.x==n-1 && curr.y==n-1) return len;
                for(Pair p : getAvailablePairs(curr,grid,vis,n))
                {
                    vis[p.x][p.y] = true;
                    dq.addLast(p);
                }
            }
            len++;
        }
        return -1;
    }
}