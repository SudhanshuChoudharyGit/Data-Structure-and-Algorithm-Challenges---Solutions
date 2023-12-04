class Solution {
    public int majorityElement(int[] nums) {
        //moore's voting algorithm
        int candidate = 0;
        int count = 0;

        for(int i=0;i<nums.length;i++)
        {
            if(count==0)
            {
                candidate = nums[i];
            }

            if(nums[i]==candidate) count++;
            else count--;
        }

        return candidate;


/*
        current == candidate
        count ++

        equal (not)
        count --

        count == 0
        candidate = current
*/
        
    }
}