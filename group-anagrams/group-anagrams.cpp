class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        //store indexes in multimap
        /*
        unordered_multimap<string,int> mp;
        vector<vector<string>> ans;
        for(int i=0;i<strs.size();i++)
        {
            string s = strs[i];
            sort(s.begin(),s.end());
            mp.insert({s,i});
        }
        auto it = mp.begin();
        while(it!=mp.end())
        {
            int x = mp.count(it->first);
            vector<string> anagrams;
            while(x--)
            {
                anagrams.push_back(strs[it->second]);
                it++;
            }
            ans.push_back(anagrams);
        }
        return ans;
        */

        //Store strings in multimap
        vector<vector<string>> ans;
        unordered_map<string,vector<string>> mp;
        for(string str : strs)
        {
            string s = str;
            sort(s.begin(),s.end());
            mp[s].push_back(str);
        }
        for(auto it : mp)
        {
            ans.push_back(it.second);
        }
        return ans;

































        /*
        multimap<string,int> mp;
        for(int i=0;i<strs.size();i++)
        {
            string s=strs[i];
            sort(s.begin(),s.end());
            mp.insert({s,i});
        }

        vector<vector<string>> ans;
        for(auto itr=mp.begin();itr!=mp.end();)
        {
            string s=itr->first;
            vector<string> v;
            int x=mp.count(s);
            while(x--)
            {
                v.push_back(strs[itr->second]);
                ++itr;
            }
            ans.push_back(v);
        }
        return ans;
        */
    }
};