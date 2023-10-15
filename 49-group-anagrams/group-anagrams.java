class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            mp.putIfAbsent(str,new ArrayList<>());
            mp.get(str).add(i);
        }
        List<List<String>> ans = new ArrayList<>();
        for(var entry : mp.entrySet())
        {
            List<String> anagrams = new ArrayList<>();
            for(int i : entry.getValue())
            {
                anagrams.add(strs[i]);
            }
            ans.add(anagrams);
        }
        return ans;
    }















/*
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp = new HashMap<>();

        for(var str : strs)
        {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String anagram = String.valueOf(ch);
            if(!mp.containsKey(anagram)) mp.put(anagram,new ArrayList<>());
            mp.get(anagram).add(str);
        }

        return new ArrayList<>(mp.values());
    }
*/
}