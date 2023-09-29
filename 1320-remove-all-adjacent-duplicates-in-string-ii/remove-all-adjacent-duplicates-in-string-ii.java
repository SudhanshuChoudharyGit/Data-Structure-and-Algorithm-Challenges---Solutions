class Pair{
    char ch;
    int freq;

    public Pair(char ch,int freq)
    {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        // Deque<Pair> -> (char,continuous freq)
        Deque<Pair> dq = new ArrayDeque<>();

        for(char c : s.toCharArray())
        {
            if(dq.size()>0 && dq.getLast().ch==c)
            {
                Pair p = dq.removeLast();
                p.freq++;
                dq.addLast(p);
                if(dq.getLast().freq==k) dq.removeLast();
            } 
            else
            {
                dq.addLast(new Pair(c,1));
            }
        }
        // make string out of linkedlist
        String ans = "";
        while(dq.size()>0)
        {
            Pair p = dq.removeFirst();
            int size = p.freq;
            while(size-- > 0) ans+=p.ch;
        }

        return ans;
    }
}