class Solution {
public:
    //**********SOLUTION************//
    //give pointers for pattern and string
    //There can be 4 situations

    //the pattern is ? 
    //the pattern and string char match
    //both cases -> increment both pointers

    //else the pattern is *
    //increment only pattern but take note of star's index and 
    //string's position (why??)
    //**because if we find unmatch afterwards then we will have to go back to
    //the next charcater to the star and start comparing it with the next character
    //in string (next one to the one that we just got while having star)
    //then in another unmatch, increament again

    //else pattern and string char do not match but
    //pattern had a star before
    //take pattern pointer next char to star
    //take string pointer next to char corresponding to  * in pattern

    //none of it -> return false

    //at the end we can only increament and ignore star's in pattern
    //if still characters left in string-> return false
    bool isMatch(string s, string p) {
        int lenS=s.length();
        int lenP=p.length();
        int indS=0;
        int indP=0;
        int indStar=-1;
        int indSS;

        while(indS<lenS)
        {
            if(indP<lenP && (p[indP]=='?' || p[indP]==s[indS]))
            {
                indS++;
                indP++;
            }
            else if(indP<lenP && p[indP]=='*')
            {
                indStar=indP++;
                indSS=indS;
            }
            else if(indStar!=-1)
            {
                indP=indStar+1;
                indS=++indSS;
            }
            else return false;
        }

        while(indP<lenP && p[indP]=='*') indP++;
        return (indP==lenP);
    }
};