class Solution {
public:

    //ugly numbers are just multiples of 2,3 and 5
    //thus producing them is just choosing to multiply with 2,3 or 5 at a time
    //starting with 1, it will look like this
    //     1
    // /   |   
    // 2   3   5
    // / | 
    // 4 6 10

    int nthUglyNumber(int n) {
        priority_queue<long,vector<long>,greater<>> pq;
        unordered_set<long> used;
        pq.push(1);
        used.insert(1);
        long x=1;
        while(n--)
        {
            x = pq.top();
            pq.pop();
            if(used.count(x*2)==0)
            {
                pq.push(x*2);
                used.insert(x*2);
            } 
            if(used.count(x*3)==0)
            {
                pq.push(x*3);
                used.insert(x*3);
            } 
            if(used.count(x*5)==0)
            {
                pq.push(x*5);
                used.insert(x*5);
            } 
        }
        return x;
    }
};