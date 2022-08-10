class Solution {
    
    class TrieNode {
        
        Map<Character, TrieNode> children;
        boolean isWord;
        
        TrieNode(){
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        TrieNode node = insertProducts(products);
        
        List<List<String>> result = new ArrayList<>();
        
        for(int i = 0; i < searchWord.length(); i++){
            
            String currentSearch = searchWord.substring(0, i + 1);
            
            TrieNode curr = searchNode(node, currentSearch);
            
            StringBuilder builder = new StringBuilder(currentSearch);
            
            List<String> currList = new ArrayList<>();
            
            dfs(curr, currList, builder);
            
            Collections.sort(currList);
            
            if(currList.size() > 3){
                result.add(currList.subList(0, 3));
            } else {
                result.add(currList);
            }
        }
        
        return result;
    }

    void dfs(TrieNode node, List<String> currList,
            StringBuilder builder){
        
        if(node == null){
            return;
        }
        
        if(node.isWord){
            currList.add(new StringBuilder(builder).toString());
        }
        
        for(Map.Entry<Character, TrieNode> entry: node.children.entrySet()){
            builder.append(entry.getKey() + "");
            dfs(entry.getValue(), currList, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
    
    TrieNode searchNode(TrieNode node, String searchWord){
        
        for(int i = 0; i < searchWord.length(); i++){
            
            if(!node.children.containsKey(searchWord.charAt(i))){
                return null;
            }
            
            node = node.children.get(searchWord.charAt(i));
        }
        
        return node;
    }
    
    
    TrieNode insertProducts(String[] products){
        
        TrieNode root = new TrieNode();
        
        for(int i = 0; i < products.length; i++){
            
            String product = products[i];
            
            TrieNode node = root;
            
            for(int j = 0; j < product.length(); j++){
                
                char c = product.charAt(j);
                
                if(!node.children.containsKey(c)){
                    node.children.put(c, new TrieNode());
                }
                
                node = node.children.get(c);
            }
            
            node.isWord = true;
        }
        
        return root;
    }
}