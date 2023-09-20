class Solution {

    public boolean ifPossible(long mid,int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long minCost = Integer.MAX_VALUE;
        for(int i=0;i<k;i++)
        {
            long currCost = 0;
            for(int j=0;j<n;j++)
            {
                if(mid*composition.get(i).get(j)<=stock.get(j)) continue;
                currCost += (mid*composition.get(i).get(j)-stock.get(j))*cost.get(j);
            }
            minCost = Math.min(currCost,minCost);
        }
        return minCost<=budget;
    }


    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long l = 0;
        long r = (int)Math.pow(10,9);
        long ans = 0;
        while(l<=r)
        {
            long mid = l +(r-l)/2;
            if(ifPossible(mid,n,k,budget,composition,stock,cost))
            {
                ans = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return (int)ans;    
    }
}