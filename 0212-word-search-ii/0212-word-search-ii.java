class Solution {
    
    class TrieNode {
        
        Map<Character, TrieNode> children;
        boolean isWord;
        
        TrieNode(){
            this.children = new HashMap<>();
        }
    }
    
    int [] [] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    private TrieNode root = new TrieNode();
    
    private void addWord(String word){
        
        TrieNode curr = root;
        
        char [] wordChar = word.toCharArray();
        
        for(char c: wordChar){
            
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            
            curr = curr.children.get(c);
        }
        
        curr.isWord = true;
    }
    
    
    public List<String> findWords(char[][] board, String[] words) {
        
        for(String word: words){
            addWord(word);
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        Set<String> result = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(root.children.containsKey(board[row][col])){
                    dfs(board, row, col, root, new StringBuilder(), result, visited);
                }
            }
        }
        
        return new ArrayList<>(result);
    }
    
    private void dfs(char[][] board, int row, int col, TrieNode node, StringBuilder builder, Set<String> result, Set<String> visited){
        
        String key = row + "," + col;
        
        if(row < 0 || row == board.length || col < 0 || col == board[0].length || visited.contains(key) || !node.children.containsKey(board[row][col])){
            return;
        }
        
        node = node.children.get(board[row][col]);
        builder.append(board[row][col]);
        visited.add(key);
        
        if(node.isWord){
            result.add(builder.toString());
        }
        
        for(int [] dir: directions){
            
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(nextRow < 0 || nextRow == board.length || nextCol < 0 || nextCol == board[0].length ||  !node.children.containsKey(board[nextRow][nextCol])){
             continue;
        }
            
            dfs(board, nextRow, nextCol, node, builder, result, visited);
        }
        
        builder.deleteCharAt(builder.length() - 1);
        visited.remove(key);
    }
    
    
}