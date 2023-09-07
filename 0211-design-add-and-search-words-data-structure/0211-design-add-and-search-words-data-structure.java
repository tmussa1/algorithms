class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, this.root, 0);
    }

    private boolean dfs(String word, TrieNode root, int index){

        for(int i = index; i < word.length(); i++){

            char c = word.charAt(i);

            if(c == '.'){
                for(TrieNode neighbor: root.children.values()){
                    if(dfs(word, neighbor, i + 1)){
                        return true;
                    }
                }
                return false;
            } else {
                if(!root.children.containsKey(c)){
                    return false;
                }
                root = root.children.get(c);
            }
        }

        return root.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */