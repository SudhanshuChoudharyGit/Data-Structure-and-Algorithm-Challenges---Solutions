class Solution {

    //merging the array then getting median
    /*
    public int[] mergeArrays(int[] nums1,int nums2[],int n,int m){
        int[] mergedArray = new int[n+m];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<n && j<m)
        {
            if(nums1[i]<=nums2[j]) mergedArray[k++] = nums1[i++];
            else mergedArray[k++] = nums2[j++];
        }
        while(i<n) mergedArray[k++] = nums1[i++];
        while(j<m) mergedArray[k++] = nums2[j++];
        return mergedArray;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k = n+m;
        int[] mergedArray = new int[k];
        mergedArray = mergeArrays(nums1,nums2,n,m);
        if(k%2!=0)
        {
            return (double)mergedArray[k/2];
        }
        else
        {
            return ((double)mergedArray[(k-1)/2]+(double)mergedArray[k/2])/2.0;
        }
    }
    */


    //without using extra space
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int totalsize = size1+size2;
        int ele2 = totalsize/2;
        int ele1 = ele2-1;
        int valEle1 = -1;
        int valEle2 = -1;
        int ptr1 = 0;
        int ptr2 = 0;
        int indCount = 0;
        while(ptr1<size1 && ptr2<size2)
        {
            if(nums1[ptr1]<=nums2[ptr2])
            {
                if(indCount==ele1) valEle1 = nums1[ptr1];
                if(indCount==ele2) valEle2 = nums1[ptr1];
                ptr1++;
                indCount++;
            }
            else
            {
                if(indCount==ele1) valEle1 = nums2[ptr2];
                if(indCount==ele2) valEle2 = nums2[ptr2];
                ptr2++;
                indCount++;
            }
        }
        while(ptr1<size1)
        {
            if(indCount==ele1) valEle1 = nums1[ptr1];
            if(indCount==ele2) valEle2 = nums1[ptr1];
            ptr1++;
            indCount++;
        }
        while(ptr2<size2)
        {
            if(indCount==ele1) valEle1 = nums2[ptr2];
            if(indCount==ele2) valEle2 = nums2[ptr2];
            ptr2++;
            indCount++;
        }
        if(totalsize%2==1) return (double)valEle2;
        else
        {
            return (double)(((double)(valEle1+valEle2))/2.0);
        }
    }




















    /*
    public int upperbound(int[] nums,int k, int n)
    {
        int l = 0;
        int r = n-1;
        int ans = 0;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(nums[m]>=k)
            {
                ans = m;
                r = m-1;
            }
            else l = m+1;
        }
        return ans;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        double ans1=0;
        if((n1+n2)%2==0)
        {
            int target = (n1+n2)/2 -1;
            int low = Math.min(nums1[0],nums2[0]);
            int high = Math.min(nums1[n1-1],nums2[n2-1]);
            while(low<=high)
            {
                int mid = (low+high)/2;
                if(upperbound(nums1,mid,n1) + upperbound(nums2,mid,n2) >= target)
                {
                    ans1 = mid;
                    high = mid - 1;
                }
                else low = mid + 1;
            }
        }
        double ans2=0;
        int target = (n1+n2)/2;
        int low = Math.min(nums1[0],nums2[0]);
        int high = Math.min(nums1[n1-1],nums2[n2-1]);
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(upperbound(nums1,mid,n1) + upperbound(nums2,mid,n2) >= target)
            {
                ans2 = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        if((n1+n2)%2==0) return (double)(ans1+ans2)/2;
        else return ans2;

    }
    */
}