class Solution {

    //O(1) space dp
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long prev = 1;
        long ans = 1;
        for(int i=1;i<n;i++)
        {
            long curr = 1;
            if(prices[i]==prices[i-1]-1) curr += prev;
            prev= curr;
            ans += curr;
        }
        return ans;
    }



    //sum solution
    /*
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
    */
}