class Solution {
    public boolean rotateString(String s, String goal) {
        for(int i=0;i<s.length();i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i)).append(s.substring(0,i));
            if(sb.toString().equals(goal)) return true;
        }
        return false;
    }
}