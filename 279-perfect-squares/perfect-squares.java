/*class Pair{
    int first;
    int second;

    public Pair() {
        first = 0;
        second = 0;
    }

    public Pair(int x,int y) {
        first = x;
        second = y;
    }
}
*/


class Solution {



    //dp
    /*
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        for(int i=1;i*i<=n;i++)
        {
            int curr = i*i;
            for(int j=curr;j<=n;j++)
            {
                dp[j]=  Math.min(dp[j],dp[j-curr]+1);
            }
        }

        return dp[n];
    }
    */

    //bfs
    /*
    public int numSquares(int n) {
        Queue<Pair> q = new LinkedList<Pair>();
        int ans = 0;
        q.add(new Pair(0,1));
        while(q.size()>0)
        {
            int levelSize = q.size();
            while(levelSize>0)
            {
                Pair p = q.poll();
                int sum = p.first;
                int index = p.second;
                if(sum==n) return ans;
                for(int i=index;i*i<=n;i++)
                {
                    if(sum+i*i<=n) q.add(new Pair(sum+i*i,i));
                }
                levelSize--;
            }
            ans++;
        }

        return ans;

    }*/

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j*j<=i;j++)
            {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
