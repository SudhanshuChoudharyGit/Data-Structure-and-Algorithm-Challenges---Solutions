class Solution {
public:

    // Using BFS - Kahn's algorithm
    // bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
    //     vector<int> adj[numCourses];
    //     for(auto v : prerequisites)
    //     {
    //         adj[v[1]].push_back(v[0]);
    //     }

    //     vector<int> numPrereq(numCourses,0);
    //     for(auto v : adj)
    //     {
    //         for(int x : v) numPrereq[x]++;
    //     }

    //     queue<int> q;
    //     for(int i=0;i<numCourses;i++)
    //     {
    //         if(numPrereq[i]==0) q.push(i);
    //     }

    //     while(!q.empty())
    //     {
    //         int course = q.front();
    //         q.pop();
    //         for(auto neighbor : adj[course])
    //         {
    //             numPrereq[neighbor]--;
    //             if(numPrereq[neighbor]==0) q.push(neighbor);
    //         }
    //     }

    //     for(int x : numPrereq) if(x!=0) return false;
    //     return true;
    // }


    //Using DFS -detect cycle; if there- false, not there- true

    bool dfs(vector<int> adj[], int node,vector<int>& vis) {
        vis[node]=1;

        for(auto x : adj[node])
        {
            if(vis[x]==1) return false;
            else if(vis[x]==0) 
            {
                if(dfs(adj,x,vis)==false) return false;
            }
        }
        vis[node]=2;
        return true;
    }

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> vis(numCourses,0);// 0- not visited, 1- visiting, 2-visited
        vector<int> adj[numCourses];
        for(auto v : prerequisites)
        {
            adj[v[1]].push_back(v[0]);
        }
        for(int x=0;x<numCourses;x++)
        {
            if(vis[x]==0)
            {
                if(dfs(adj,x,vis)==false) return false;
            }
        }
        return true;
    }




};