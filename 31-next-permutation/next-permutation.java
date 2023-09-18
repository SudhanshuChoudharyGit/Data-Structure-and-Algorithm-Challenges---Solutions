class Solution {

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        //break point - bp
        int bp = -1;
        int n = nums.length;
        for(int i=n-1;i>=1;i--)
        {
            if(nums[i]>nums[i-1]) 
            {
                bp = i-1;
                break;
            }
        }

        //swap bp with next greater
        if(bp!=-1)
        {
            int nextgreater = bp;
            int num = Integer.MAX_VALUE;
            for(int j=bp+1;j<n;j++)
            {
                if(nums[j]<=num && nums[j]>nums[bp])
                {
                    nextgreater = j;
                    num = nums[j];
                } 
            }
            swap(nums,bp,nextgreater);
        }

        //reverse whole array after bp
        int l = bp+1;
        int r = n-1;
        while(l<r)
        {
            swap(nums,l,r);
            l++;
            r--;
        }

    }
}