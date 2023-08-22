class Solution {
public:

    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<vector<int>,vector<vector<int>>,greater<>> pq;
        for(int i=0;i<matrix.size();i++)
        {
            pq.push({matrix[i][0],i,0});
        }
        k--;
        while(k--)
        {
            vector<int> v= pq.top();
            pq.pop();
            int val= v[0];
            int listInd = v[1];
            int ind = v[2];
            if(ind<matrix[listInd].size()-1)
            pq.push({matrix[listInd][ind+1],listInd,ind+1});
        }
        vector<int> v= pq.top();
        return v[0];
    }
































/*
    int kthSmallest(vector<vector<int>>& matrix, int k) {

        using min heap
        treating all rows as lists, inserting all initial numbers in min heap, pop out the        top of min heap (ie the smallest number) and push the next element in that row (if exists)
        kth time, it will be that kth smallest element

        priority_queue<vector<int>,vector<vector<int>>,greater<>> pq;
        int n=matrix.size();
        for(int i=0;i<n;i++)
        {
            pq.push({matrix[i][0],i,0});
        }
        int ans;
        for(int i=0;i<k;i++)
        {
            auto v= pq.top();
            pq.pop();
            int r=v[1]; int c=v[2];
            ans =v[0];
            if(c+1<n) pq.push({matrix[r][c+1],r,c+1});
        }
        return ans;


        using binary search
        taking matrix[0][0] and matrix[n-1][n-1] elements as lower and upper bound
        run the binary search
        search ends where low becomes or crosses high, where we find number of elements
        less than or equal to the mid, then we compare this number with k

        int n=matrix.size();
        int l=matrix[0][0];
        int r=matrix[n-1][n-1];
        while(l<r)
        {
            int m=(l+r)>>1;
            int count=0;
            for(auto v:matrix)
            {
                int x=upper_bound(v.begin(),v.end(),m)-v.begin();
                count+=x;
            }
            if(count<k) l=m+1;
            else r=m;
        }
        return l;
}
*/

};