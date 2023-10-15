class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxOnLeft = -1;
        int maxOnRight = -1;
        int trappedWater = 0;
        while(left<right)
        {
            maxOnLeft = Math.max(maxOnLeft,height[left]);
            maxOnRight = Math.max(maxOnRight,height[right]);
            if(maxOnLeft<=maxOnRight)
            {
                trappedWater += maxOnLeft-height[left];
                left++;
            }
            else
            {
                trappedWater += maxOnRight-height[right];
                right--;
            }
        }
        return trappedWater;
    }















/*


    public int trap(int[] height) {
        // sum + = trap[i] = min(max on left, max on right) - currval
        // maxleft = height
        // maxright = n-1
        // if(left<=right)
        // sum += maxleft - currleft
        // else
        // sum += maxright - currright

        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxleft = height[left];
        int maxright = height[right];
        int sum = 0;
        while(left<right)
        {
            if(maxleft<=maxright)
            {
                sum += maxleft - height[left];
                left++;
                maxleft = Math.max(maxleft,height[left]);
            }
            else
            {
                sum += maxright - height[right];
                right--;
                maxright = Math.max(maxright,height[right]);
            }
        }
        return sum;
    }

*/
}