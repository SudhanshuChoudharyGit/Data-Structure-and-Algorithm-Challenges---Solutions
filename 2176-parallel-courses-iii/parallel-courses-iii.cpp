class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        int ans=0;
        vector<int> adj[n];
        for(auto relation : relations)
        {
            adj[relation[0]-1].push_back(relation[1]-1);
        }

        vector<int> numPrereq(n,0);
        for(auto v : adj)
        {
            for(int x : v) numPrereq[x]++;
        }

        queue<int> q;
        for(int i=0;i<n;i++)
        {
            if(numPrereq[i]==0) q.push(i);
        }

        vector<int> timeTaken(n,0);
        for(int i=0;i<n;i++) timeTaken[i]=time[i];

        while(!q.empty())
        {
            int size = q.size();
            while(size--)
            {
                int course = q.front();
                ans=max(ans,time[course]);
                q.pop();
                for(auto neighbor : adj[course])
                {
                    timeTaken[neighbor]=max(timeTaken[neighbor],timeTaken[course]+time[neighbor]);
                    ans = max(timeTaken[neighbor],ans);
                    numPrereq[neighbor]--;
                    if(numPrereq[neighbor]==0) q.push(neighbor);
                }
            }
        }
        return ans;
    }
};