class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int num = Character.getNumericValue(c);
                decodedLength *= num;
            } else {
                decodedLength++;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= decodedLength;
            
            if (k == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }

            if (Character.isDigit(c)) {
                int num = Character.getNumericValue(c);
                decodedLength /= num;
            } else {
                decodedLength--;
            }
        }

        return "";
    }
}




