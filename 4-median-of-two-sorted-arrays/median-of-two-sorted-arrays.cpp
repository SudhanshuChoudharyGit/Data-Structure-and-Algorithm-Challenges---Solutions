class Solution {
public:

    int getCount(vector<int> nums,int k) {
        int count=0;
        int l=0;
        int r=nums.size()-1;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(nums[m]<k)
            {
                count = m+1;
                l=m+1;
            }
            else r=m-1;
        }
        return count;
    }

    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n=nums1.size();
        int m=nums2.size();
        if(m==0)
        {
            if(n%2==0) return (double)((nums1[n/2-1]+nums1[n/2])/2.0);
            else return (double)nums1[n/2.0];
        }
        else if(n==0)
        {
            if(m%2==0) return (double)(((double)nums2[m/2-1]+(double)nums2[m/2])/2.0);
            else return (double)nums2[m/2.0];
        }
        int total = n+m;
        int k;
        double first;
            k= total/2+1;
            //find kth smallest number
            int l=min(nums1[0],nums2[0]);
            int r=max(nums1[n-1],nums2[m-1]);
            while(l<=r)
            {
                int mid = l + (r-l)/2;
                //find number of elements smaller than m
                int count = getCount(nums1,mid)+getCount(nums2,mid);
                if(count<k)
                {
                    first=mid;
                    l=mid+1;
                }
                else r=mid-1;
            }
        if(total%2!=0) return double(first);
        k=total/2;
        double second;
        //find kth smallest number
            l=min(nums1[0],nums2[0]);
            r=max(nums1[n-1],nums2[m-1]);
            while(l<=r)
            {
                int mid = l + (r-l)/2;
                //find number of elements smaller than m
                int count = getCount(nums1,mid)+getCount(nums2,mid);
                if(count<k)
                {
                    second=mid;
                    l=mid+1;
                }
                else r=mid-1;
            }
        return double((first+second)/2);
    }
};