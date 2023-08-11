class Solution {
public:
    //bfs
    int openLock(vector<string>& deadends, string target) {
        if(target=="0000") return 0;
        vector<char> num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        queue<string> q;
        unordered_set<string> vis;
        q.push("0000");
        for(string dead : deadends)
        {
            vis.insert(dead);
        }
        if(vis.count("0000")!=0) return -1;
        int step=0;
        while(!q.empty())
        {
            int sizeStep = q.size();
            while(sizeStep--)
            {
                string slot = q.front();
                if(slot==target) return step;
                q.pop();
                for(int index=0;index<4;index++)
                {   
                    string stepup;
                    if(slot[index]=='9') stepup = slot.substr(0,index) + '0' + slot.substr(index+1);
                    else stepup = slot.substr(0,index) + num[slot[index]-'0'+1] + slot.substr(index+1);
                    string stepdown;
                    if(slot[index]=='0') stepdown = slot.substr(0,index) + '9' + slot.substr(index+1);
                    else stepdown = slot.substr(0,index) + num[slot[index]-'0'-1] + slot.substr(index+1);
                    if(vis.count(stepup)==0)
                    {
                        vis.insert(stepup);
                        q.push(stepup);
                    }
                    if(vis.count(stepdown)==0)
                    {
                        vis.insert(stepdown);
                        q.push(stepdown);
                    }
                }
            }
            step++;
        }
        return -1;
    }
};