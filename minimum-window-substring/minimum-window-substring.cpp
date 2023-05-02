class Solution {
public:

    string minWindow(string s, string t) {
        //created map for t
        unordered_map<char,int> mpt;
        for(char c: t)
        {
            mpt[c]++;
        }

        int need = mpt.size();
        int have=0;
        unordered_map<char,int> mps;
        int len=INT_MAX;
        int start=-1;
        int l=0;
        int r=0;
        while(r<s.length())
        {
            mps[s[r]]++;
            if(mpt.find(s[r])!=mpt.end() && mpt[s[r]]==mps[s[r]]) have++;
            while(have==need)
            {
                if(len>r-l+1)
                {
                    len=r-l+1;
                    start=l;
                }
                mps[s[l]]--;
                if(mpt.find(s[l])!=mpt.end() && mpt[s[l]]>mps[s[l]]) have--;
                l++;
            }
            r++;
        }
        if(len==INT_MAX) return "";
        else return s.substr(start,len);   
    }

};