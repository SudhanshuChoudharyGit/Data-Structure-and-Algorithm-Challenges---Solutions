class Solution {
public:
    int maxArea(vector<int>& height) {
        //start from the ends, as they have the most wide containers
        //calculate again only if you find a height greater than initial effH
        //otherwise keep moving from both sides
        int i=0;
        int j=height.size()-1;
        int effH=0;
        int ans=0;
        while(i<j)
        {
            effH=min(height[i],height[j]);
            ans=max(ans,effH*(j-i));
            while(height[i]<=effH && i<j) i++;
            while(height[j]<=effH && i<j) j--;
        }
        return ans;
    }
};