class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = -1;
        int profit = 0;
        for(int i=0;i<n-1;i++)
        {
            if(buy==-1)
            {
                if(prices[i+1]>prices[i]) buy = i;
            }
            else
            {
                if(prices[i+1]<prices[i])
                {
                    profit += (prices[i]-prices[buy]);
                    buy = -1;
                }
            }
        }
        if(buy!=-1) profit += (prices[n-1]-prices[buy]);
        return profit;
    }
}