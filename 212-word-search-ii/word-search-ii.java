class Node{
        String word;
        Node[] children;

        public Node(){
            word = null;
            children = new Node[26];
            for(int i=0;i<26;i++) children[i] = null;
        }
    }

class Trie{
    Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String str) {
		Node temp = root;
		for(char ch : str.toCharArray())
		{
			int ind = ch - 'a';
			if(temp.children[ind]==null) temp.children[ind] = new Node();
			temp = temp.children[ind];
		}
		temp.word = str;
	}
}



class Solution {


    public void dfs(int i,int j,char[][] board,Node node,List<String> ans,int m,int n) {
        char c = board[i][j];
        if(c=='#' || node.children[c-'a']==null) return;
        node = node.children[c-'a'];
        if(node.word!=null)
        {
            ans.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if(i>0) dfs(i-1,j,board,node,ans,m,n);
        if(j>0) dfs(i,j-1,board,node,ans,m,n);
        if(i<m-1) dfs(i+1,j,board,node,ans,m,n);
        if(j<n-1) dfs(i,j+1,board,node,ans,m,n);
        board[i][j] = c;
    }


    public List<String> findWords(char[][] board, String[] words) {
        //trie ds
        //insert all word from words
        //iterate over board
        //mark places with # to show visited
        //traverse in trie side by side
        //so incase it is # in board || null in trie - don't go ahead
        Trie trie = new Trie();
        for(String word : words) trie.insert(word);

        int m = board.length;
        int n = board[0].length;

        List<String> ans = new ArrayList<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dfs(i,j,board,trie.root,ans,m,n);
            }
        }

        return ans;
    }
}