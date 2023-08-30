class Solution {
    public int numSquares(int n) {
        List<Integer> perfectSquares = new ArrayList<Integer>();

        int index = 1;
        while(index*index<=n)
        {
            perfectSquares.add(index*index);
            index++;
        }

        int size = perfectSquares.size();
        int[] dp = new int[n+1];
        
        for(int i=0;i<=n;i++) dp[i]=i;

        for(int i=1;i<size;i++)
        {
            for(int j=perfectSquares.get(i);j<=n;j++)
            {
                dp[j]=  Math.min(dp[j],dp[j-perfectSquares.get(i)]+1);
            }
        }

        return dp[n];
    }
}