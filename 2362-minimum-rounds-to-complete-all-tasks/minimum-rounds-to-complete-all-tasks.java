class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> diff = new HashMap<>();
        for(int task : tasks)
        {
            int currdiff = diff.getOrDefault(task,0);
            diff.put(task,currdiff+1);
        }
        int rounds = 0;
        for(var entry : diff.entrySet())
        {
            int val = entry.getValue();
            if(val<=1) return -1;
            if(val%3==0) rounds += val/3;
            else rounds += (val/3)+1;
        }

        return rounds;
    }
}