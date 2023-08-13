class Solution {
public:

    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> ans;
        vector<int> adj[numCourses];

        for(auto v : prerequisites)
        {
            adj[v[1]].push_back(v[0]);
        }

        vector<int> numPrereq(numCourses,0);
        for(int i=0;i<numCourses;i++)
        {
            for(int x : adj[i]) numPrereq[x]++;
        }

        queue<int> q;
        for(int i=0;i<numCourses;i++)
        {
            if(numPrereq[i]==0) q.push(i);
        }

        while(!q.empty())
        {
            int course = q.front();
            ans.push_back(course);
            q.pop();
            for(int x : adj[course])
            {
                numPrereq[x]--;
                if(numPrereq[x]==0) q.push(x);
            }
        }

        for(int x : numPrereq)
        {
            if(x!=0) return {};
        }

        return ans;

    }









































    // vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
    //     vector<int> adj[numCourses];
    //     for(auto p : prerequisites) adj[p[1]].push_back(p[0]);
    //     vector<int> in(numCourses,0);
    //     vector<int> topo;
    //     queue<int> q;
    //     for(int i=0;i<numCourses;i++)
    //     {
    //         for(auto j : adj[i]) in[j]++;
    //     }
    //     for(int i=0;i<numCourses;i++)
    //     {
    //         if(!in[i]) q.push(i);
    //     }
    //     while(!q.empty())
    //     {
    //         int node = q.front();
    //         q.pop();
    //         topo.push_back(node);
    //         for(auto x : adj[node])
    //         {
    //             in[x]--;
    //             if(!in[x]) q.push(x);
    //         }
    //     }
    //     if(topo.size()!=numCourses) return {};
    //     return topo;
    // }
};