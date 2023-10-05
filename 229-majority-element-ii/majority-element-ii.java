class Solution {

    //moore's voting algo
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length/3;
        long ele1 = (long)Math.pow(10,9)+1;
        long ele2 = (long)Math.pow(10,9)+2;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int x : nums)
        {
            if(cnt1==0 && x!=ele2)
            {
                ele1 = x;
                cnt1 = 1;
            }
            else if(cnt2==0 && x!=ele1)
            {
                ele2 = x;
                cnt2 = 1;
            }
            else if(x == ele1) cnt1++;
            else if(x == ele2) cnt2++;
            else
            {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0; cnt2 = 0;
        for(int x : nums)
        {
            if(x==ele1) cnt1++;
            else if(x==ele2) cnt2++;
        }
        List<Integer> list = new ArrayList<>();
        if(cnt1>len) list.add((int)ele1);
        if(cnt2>len) list.add((int)ele2);
        return list;
    }

    //hashing
    /*
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        len = len/3;
        for(int x : nums)
        {
            int f = freq.getOrDefault(x,0);
            freq.put(x,f+1);
            if(freq.get(x)==len+1) list.add(x);
        }
        
        return list;
    }
    */
}