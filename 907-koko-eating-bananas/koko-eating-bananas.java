class Solution {


    public boolean isPossible(int[] piles, int h,int k){
        int hours = 0;
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]<k) hours++;
            else
            {
                if(piles[i]%k!=0) hours++;
                hours += piles[i]/k;
                if(hours>h) return false;
            }
        }
        if(hours<=h) return true;
        else return false;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        for(int x : piles) r= Math.max(x,r);
        int ans = -1;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(isPossible(piles,h,m))
            {
                ans = m;
                r = m-1;
            }
            else l = m+1;
        }
        return ans;
    }
}