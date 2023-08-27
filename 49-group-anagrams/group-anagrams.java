class Solution {


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
}