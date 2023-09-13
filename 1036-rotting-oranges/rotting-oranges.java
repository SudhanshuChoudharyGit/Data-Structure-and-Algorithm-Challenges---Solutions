class Pair{
    int x;
    int y;

    public Pair(int x,int y){
        this.x = x;
        this.y =y;
    }
}

class Solution {


    public ArrayList<Pair> getNeighbours(Pair pos, int[][] grid,int m,int n){
        ArrayList<Pair> ans = new ArrayList<>();
        int i = pos.x;
        int j = pos.y;
        if(i-1>=0 && i-1<m && j>=0 && j<n && grid[i-1][j]==1) ans.add(new Pair(i-1,j));
        if(i>=0 && i<m && j-1>=0 && j-1<n && grid[i][j-1]==1) ans.add(new Pair(i,j-1));
        if(i>=0 && i<m && j+1>=0 && j+1<n && grid[i][j+1]==1) ans.add(new Pair(i,j+1));
        if(i+1>=0 && i+1<m && j>=0 && j<n && grid[i+1][j]==1) ans.add(new Pair(i+1,j));
        return ans;
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<Pair> rotten = new ArrayDeque<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2) rotten.addLast(new Pair(i,j));
            }
        }
        int minutes = 0;
        while(rotten.size()>0)
        {
            int levelsize = rotten.size();
            while(levelsize>0)
            {
                Pair pos = rotten.removeFirst();
                for(var nb : getNeighbours(pos,grid,m,n))
                {
                    grid[nb.x][nb.y] = 2;
                    rotten.addLast(nb);
                }
                levelsize--;
            }
            minutes++;
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1) return -1;
            }
        }
        return (minutes==0) ? 0 : minutes-1;

    }
}