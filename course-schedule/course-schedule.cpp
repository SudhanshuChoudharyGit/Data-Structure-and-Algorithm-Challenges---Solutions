class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        //makes an adjecency list where
        //isPRof[x] : contains list of courses which have x as one of the prereq
        vector<vector<int>> isPRof(numCourses);
        for(auto pr : prerequisites)
        {
            isPRof[pr[0]].push_back(pr[1]);
        }

        //array which gives number of prereq of all the courses
        vector<int> noofPR(numCourses);

        //obtained via traversing through isPRof
        for(auto courses : isPRof)
        {
            for(int x : courses)
            {
                noofPR[x]++;
            }
        }

        queue<int> q;
        
        //pushes all course with zero prereq into queue
        for(int i=0;i<numCourses;i++)
        {
            if(noofPR[i]==0) q.push(i);
        }

        int count=0;

        while(!q.empty())
        {
            int x= q.front();
            q.pop();
            count++;
            for(auto ele : isPRof[x])
            {
                noofPR[ele]--;
                if(noofPR[ele]==0) q.push(ele);
            }
        }

        if(count==numCourses) return true;
        else return false;


    }
};