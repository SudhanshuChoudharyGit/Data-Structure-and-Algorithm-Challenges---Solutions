class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        int len = INT_MAX;
        int l,r;
        l=r=0;
        unordered_map<int,int> mp;
        while(r<cards.size())
        {
            mp[cards[r]]++;
            while(mp[cards[r]]>1)
            {
                len = min(len,r-l+1);
                mp[cards[l]]--;
                l++;
            }
            r++;
        }
        return len==INT_MAX ? -1 : len;
    }
};