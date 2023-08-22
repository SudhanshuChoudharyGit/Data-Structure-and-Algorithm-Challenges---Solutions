class Solution {
public:
    string reorganizeString(string s) {
        vector<int> freq(26,0);
        for(char c : s) freq[c-'a']++;
        priority_queue<pair<int,char>> pq;
        for(int i=0;i<26;i++)
        {
            if(freq[i]>0)
            {
                pq.push({freq[i],'a'+i});
            }
        }
        int n=s.length();
        if(pq.top().first>(n+1)/2) return "";
        vector<char> ans(n);
        int ptr = 0;
        while(!pq.empty())
        {
            int count = pq.top().first;
            char character = pq.top().second;
            pq.pop();
            while(count--)
            {
                ans[ptr]=character;
                ptr+=2;
                if(ptr>=n) ptr=1;
            }
        }
        string arr="";
        for(char c : ans) arr+=c;
        return arr;
    }
};