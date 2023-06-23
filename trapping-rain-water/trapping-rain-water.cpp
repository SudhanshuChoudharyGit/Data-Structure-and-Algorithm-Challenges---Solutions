class Solution {
public:
    int trap(vector<int>& height) {
        int sum=0;
        int max_left=0;
        int max_right=0;
        int left=0;
        int right=height.size()-1;
        while(left<right)
        {
            max_left=max(max_left,height[left]);
            max_right=max(max_right,height[right]);
            if(max_left<=max_right)
            {
                sum+=(max_left-height[left]);
                left++;
            }
            else
            {
                sum+=(max_right-height[right]);
                right--;
            }
        }
        return sum;
    }
};