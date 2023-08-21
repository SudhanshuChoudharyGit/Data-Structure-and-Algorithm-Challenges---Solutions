class Solution {
public:
    int compress(vector<char>& chars) {
        int l,r;
        l=r=0;
        int count=0;
        string ans="";
        while(r<chars.size())
        {
            while(r<chars.size() && chars[r]==chars[l])
            {
                count++;
                r++;
            }
            ans+=chars[l];
            if(count>1) ans+=to_string(count);
            l=r;
            count=0;
        }
        chars.clear();
        for(auto c : ans)
        {
            chars.push_back(c);
        }
        return ans.length();
    }
};