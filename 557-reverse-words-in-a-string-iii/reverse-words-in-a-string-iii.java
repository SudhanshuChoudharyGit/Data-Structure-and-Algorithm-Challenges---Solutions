class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sbr = new StringBuilder();
        for(String str : arr)
        {
            StringBuffer sbf = new StringBuffer(str);
            sbf = sbf.reverse();
            sbr.append(sbf.toString()).append(" ");
        }
        sbr.deleteCharAt(sbr.length()-1);
        return sbr.toString();
    }
}