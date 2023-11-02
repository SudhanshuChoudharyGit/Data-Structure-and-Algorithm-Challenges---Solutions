class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long currLen = 1;
        long sum = 0;
        for(int i=0;i<n;i++)
        {
            if(i+1<n && prices[i+1]+1==prices[i]) currLen++;
            else 
            {
                sum += currLen*(currLen+1)/2;
                currLen = 1;
            }
        }
        return sum;
    }
}