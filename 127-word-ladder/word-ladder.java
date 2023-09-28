class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);
        if(!set.contains(endWord)) return 0;
        Deque<String> dq = new ArrayDeque<>();
        dq.addLast(beginWord);
        if(set.contains(beginWord)) set.remove(beginWord);
        int ans = 1;

        while(dq.size()>0)
        {
            int size = dq.size();
            while(size-- >0)
            {
                String currWord = dq.removeFirst();
                if(currWord.equals(endWord)) return ans;
                //generate next words
                for(int i=0;i<currWord.length();i++)
                {
                    for(int j=0;j<26;j++)
                    {
                        String genWord = currWord.substring(0,i) + (char)('a'+j) + currWord.substring(i+1,currWord.length());
                        if(!genWord.equals(currWord) && set.contains(genWord))
                        {
                            dq.addLast(genWord);
                            set.remove(genWord);
                        } 
                    }
                }
                
            }
            ans++;
        }

        return 0;
        
    }
}