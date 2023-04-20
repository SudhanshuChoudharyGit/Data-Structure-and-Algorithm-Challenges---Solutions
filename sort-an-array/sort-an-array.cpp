class Solution {
public:

    void merge(vector<int>& nums,int l,int r,int m){
        int n1=m-l+1;
        int n2=r-m;

        vector<int> a1;
        vector<int> a2;

        for(int i=0;i<n1;i++) a1.push_back(nums[l+i]);
        for(int i=0;i<n2;i++) a2.push_back(nums[m+i+1]);

        int i=0;int j=0;int k=l;
        while(i<n1 && j<n2)
        {
            if(a1[i]<a2[j]) nums[k++]=a1[i++];
            else nums[k++]=a2[j++];
        }
        while(i<n1) nums[k++]=a1[i++];
        while(j<n2) nums[k++]=a2[j++];
    }

    void mergesort(vector<int>& nums,int l,int r){
        if(l==r) return;
        int m = (l+r)>>1;
        mergesort(nums,l,m);
        mergesort(nums,m+1,r);
        merge(nums,l,r,m);
    }

    vector<int> sortArray(vector<int>& nums) {
        //merge sort
        mergesort(nums,0,nums.size()-1);
        return nums;
    }
};