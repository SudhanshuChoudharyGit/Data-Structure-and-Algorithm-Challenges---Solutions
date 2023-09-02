class Trie {

    private HashMap<Character,Trie> children;
    boolean isWord;

    public Trie() {
        children = new HashMap<>();
        isWord = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for(char c : word.toCharArray())
        {
            node.children.putIfAbsent(c,new Trie());
            node = node.children.get(c);
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        for(char c : word.toCharArray())
        {
            if(!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return node.isWord == true;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        for(char c : prefix.toCharArray())
        {
            if(!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */