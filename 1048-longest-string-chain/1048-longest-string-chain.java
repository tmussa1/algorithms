class Solution {
    
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words);
        
        Set<String> wordDict = new HashSet<>();
        Collections.addAll(wordDict, words);
        
        Map<String, List<String>> adjList = constructAdjList(words, wordDict);
        
        int result = 0;
        
         Map<String, Integer> cache = new HashMap<>();
        
        for(String word: words){
            result = Math.max(result, dfs(word, adjList, cache));
        }
        
        return result;
    }
    
    private int dfs(String node, 
                    Map<String, List<String>> adjList, 
                    Map<String, Integer> cache){
       
        if(cache.containsKey(node)){
            return cache.get(node);
        }
        
        int result = 1;
        
        if(adjList.get(node) != null) {
            for(String neighbor: adjList.get(node)){
               result = Math.max(result, 1 + dfs(neighbor, adjList, cache));
            }
        }
        
        cache.put(node, result);
        
        return result;
    }
    
    Map<String, List<String>> constructAdjList(String[] words, Set<String> wordDict){
        
        Map<String, List<String>> adjList = new HashMap<>();
        
        for(String word: words){
            
            for(int i = 0; i < word.length(); i++){
                
                String key = word.substring(0, i) + word.substring(i + 1);
                
                if(wordDict.contains(key)){
                    List<String> lst = adjList.getOrDefault(key, new ArrayList<>());
                    lst.add(word);
                    adjList.put(key, lst);
                }
            }
        }
        
        return adjList;
    }
}