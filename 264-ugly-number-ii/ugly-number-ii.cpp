class Solution {
public:

    //using pointers
    int nthUglyNumber(int n) {
        int p2,p3,p5;
        p2=p3=p5=0;
        vector<int> ugly(n);
        ugly[0]=1;
        int num = 1;
        for(int i=1;i<n;i++)
        {
            num = min(ugly[p2]*2,min(ugly[p3]*3,ugly[p5]*5));
            ugly[i]=num;
            if(num == ugly[p2]*2) p2++;
            if(num == ugly[p3]*3) p3++;
            if(num == ugly[p5]*5) p5++;
        }
        return num;
    }

    //using priority queue
    // int nthUglyNumber(int n) {
    //     priority_queue<long,vector<long>,greater<>> pq;
    //     unordered_set<long> used;
    //     pq.push(1);
    //     used.insert(1);
    //     n--;
    //     while(n--)
    //     {
    //         int x = pq.top();
    //         pq.pop();
    //         if(used.count(x*2l)==0)
    //         {
    //             pq.push(x*2l);
    //             used.insert(x*2l);
    //         } 
    //         if(used.count(x*3l)==0)
    //         {
    //             pq.push(x*3l);
    //             used.insert(x*3l);
    //         } 
    //         if(used.count(x*5l)==0)
    //         {
    //             pq.push(x*5l);
    //             used.insert(x*5l);
    //         } 
    //     }
    //     return pq.top();
    // }
};