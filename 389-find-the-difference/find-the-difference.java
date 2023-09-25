class Solution {
    public char findTheDifference(String s, String t) {
        int sumS = 0;
        int sumT = 0;
        for(char c : s.toCharArray()) sumS += c - 'a';
        for(char c : t.toCharArray()) sumT += c - 'a';
        char ans = (char)((sumT-sumS)+'a');
        return ans;
    }
}