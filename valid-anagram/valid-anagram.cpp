class Solution {
public:
    bool isAnagram(string s, string t) {
        //sorting
        //T = O(nlongn) S = O(1)
        /*
        sort(s.begin(),s.end());
        sort(t.begin(),t.end());
        return (s==t);
        */

        //freq array - if needed unicode - not good

        //map
        unordered_map<char,int> mp;
        for(char c : s) mp[c]++;

        for(char c : t)
        {
            if(mp.count(c)==0) return false;
            mp[c]--;
        }

        for(auto it : mp)
        {
            if(it.second!=0) return false;
        }
        return true;

    }
};