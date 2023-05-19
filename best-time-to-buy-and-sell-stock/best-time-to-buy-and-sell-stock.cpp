class Solution {
public:
    int maxProfit(vector<int>& prices) {

        int minprice=INT_MAX;
        int maxprice=-1;
        int ans=0;
        for(int price : prices)
        {
            maxprice=max(maxprice,price);
            if(price<minprice)
            {
                minprice=min(minprice,price);
                maxprice=price;
            }
            ans=max(ans,maxprice-minprice);
        }
        return ans;

        /*int n=prices.size();
        vector<int> left_min(n,0);
        vector<int> right_max(n,0);

        int min=INT_MAX;
        int max=INT_MIN;

        for(int i=0;i<n;i++)
        {
            if(prices[i]<min) min=prices[i];
            if(prices[n-i-1]>max) max=prices[n-i-1];
            left_min[i]=min;
            right_max[n-i-1]=max;
        }

        int ans=INT_MIN;

        for(int i=0;i<n;i++)
        {
            if(right_max[i]-left_min[i]>ans) ans=right_max[i]-left_min[i]; 
        }

        return ans;*/

        /*int n=prices.size();
        int buy=INT_MAX;
        bool bought=false;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(i<n-1)
            {
                if(prices[i+1]>prices[i] && prices[i]<buy)
                {
                    buy=prices[i];
                    bought=true;
                }
            }
            if(bought)
            {
                if(prices[i]-buy>ans) ans=prices[i]-buy;
            }
        }
        return ans;*/

        /*int ans=0;
        int buy=0;
        for(int sell=1;sell<prices.size();sell++)
        {
            ans=max(ans,prices[sell]-prices[buy]);
            if(prices[sell]<prices[buy]) buy=sell;
        }
        return ans;*/
    }
};