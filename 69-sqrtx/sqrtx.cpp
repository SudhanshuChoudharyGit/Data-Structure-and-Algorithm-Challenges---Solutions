class Solution {
public:
    int mySqrt(int x) {
        if(x==0) return 0;
        int left=1;
        int right=x;
        int boundary_num=1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(mid <= (x/mid))
            {
                boundary_num=mid;
                left=mid+1;
            }
            else right=mid-1;
        }
        return boundary_num;
    }
};