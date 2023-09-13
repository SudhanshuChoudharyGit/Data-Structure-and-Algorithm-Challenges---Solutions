class Solution {

    public boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length()-1;
        while(l<r)
        {
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public void backtrack(String s,int index,ArrayList<String> curr,List<List<String>> ans) {
        if(index==s.length())
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<s.length();i++)
        {
            String substr = s.substring(index,i+1);
            if(!isPalindrome(substr)) continue;
            curr.add(substr);
            backtrack(s,i+1,curr,ans);
            curr.remove(curr.size()-1);
        }      
    }

    public List<List<String>> partition(String s) {
        ArrayList<String> curr = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        backtrack(s,0,curr,ans);
        return ans;
    }
}