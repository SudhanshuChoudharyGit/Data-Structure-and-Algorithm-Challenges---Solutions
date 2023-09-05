class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            if(i>=k && nums[i-k]==dq.getFirst()) dq.removeFirst();
            while(dq.size()>0 && dq.getLast()<nums[i]) dq.removeLast();
            dq.addLast(nums[i]);
            if(i>=k-1) ans.add(dq.getFirst());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}