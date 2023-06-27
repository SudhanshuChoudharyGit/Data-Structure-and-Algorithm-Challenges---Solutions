class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        //checking rows and columns
        for(int i=0;i<9;i++)
        {
            unordered_set<int> row_numbers;
            unordered_set<int> column_numbers;
            for(int j=0;j<9;j++)
            {
                if(row_numbers.find(board[i][j])!=row_numbers.end() || column_numbers.find(board[j][i])!=column_numbers.end()) return false;
                if(board[i][j]!='.') row_numbers.insert(board[i][j]);
                if(board[j][i]!='.') column_numbers.insert(board[j][i]);
            }
        }

        //checking 3*3 boxes
        for(int i1=0;i1<9;i1+=3)
        {
            for(int j1=0;j1<9;j1+=3)
            {
                unordered_set<int> box_numbers;
                for(int i=i1;i<=i1+2;i++)
                {
                    for(int j=j1;j<=j1+2;j++)
                    {
                        if(box_numbers.find(board[i][j])!=box_numbers.end()) return false;
                        if(board[i][j]!='.') box_numbers.insert(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
};