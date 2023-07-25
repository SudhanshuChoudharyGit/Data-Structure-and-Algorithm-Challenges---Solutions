class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        int left=0;
        int right = letters.size()-1;
        int boundary_ind=0;
        while(left<=right)
        {
            int mid = left+ (right-left)/2;
            if(letters[mid]-target>0)
            {
                boundary_ind=mid;
                right=mid-1;
            }
            else left=mid+1;
        }
        return letters[boundary_ind];
    }
};