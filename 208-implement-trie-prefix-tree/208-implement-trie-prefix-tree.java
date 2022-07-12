class Trie {

    private Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        
        Node node = this.root;
        
        for(int i = 0; i < word.length(); i++){
            
            char c = word.charAt(i);
            
            if(!node.children.containsKey(c)){
                node.children.put(c, new Node());
            }
            
            node = node.children.get(c);
        }
        
        node.isWord = true;
    }
    
    public boolean search(String word) {
        
        Node node = this.root;
        
        for(int i = 0; i < word.length(); i++) {
           
             char c = word.charAt(i);
            
             if(!node.children.containsKey(c)){
                 return false;
             }
            
             node = node.children.get(c);
        }
        
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        
        Node node = this.root;
        
        for(int i = 0; i < prefix.length(); i++){
            
            char c = prefix.charAt(i);
            
            if(!node.children.containsKey(c)){
                 return false;
             }
            
            node = node.children.get(c);
        }
        
        return true;
    }
    
    class Node {
        
        boolean isWord;
        Map<Character, Node> children;
        
        Node(){
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */