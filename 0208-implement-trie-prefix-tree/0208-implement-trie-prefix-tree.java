class Trie {
    
    class TrieNode {
        
        char c;
        Map<Character, TrieNode> children;
        boolean isWord;
        
        TrieNode(){
            this.children = new HashMap<>();
        }
    }
    
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        
        char [] chArr = word.toCharArray();
        
        TrieNode curr = root;
        
        for(char c: chArr){
            
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            
            curr = curr.children.get(c);
        }
        
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        
        char [] chArr = word.toCharArray();
        
        TrieNode curr = root;
        
        for(char c: chArr){
            
            if(!curr.children.containsKey(c)){
               return false;
            }
            
            curr = curr.children.get(c);
        }
        
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        
        char [] chArr = prefix.toCharArray();
        
        TrieNode curr = root;
        
        for(char c: chArr){
            
            if(!curr.children.containsKey(c)){
               return false;
            }
            
            curr = curr.children.get(c);
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