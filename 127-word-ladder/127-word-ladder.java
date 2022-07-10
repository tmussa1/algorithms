class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int [] level = new int[1];
        level[0] = 1;
        
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
            level[0] = 0;
        }
        
        Map<String, List<String>> adjList = constructAdjList(wordList);
        
        System.out.println(adjList);
        
        return bfs(adjList, beginWord, endWord);
    }
    
    int bfs(Map<String, List<String>> adjList, String beginWord, String endWord){
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int result = 1;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                String currWord = queue.poll();
                
                if(currWord.equals(endWord)) return result;
                
                for(String element: adjList.get(currWord)){
                    if(!visited.contains(element)){
                        visited.add(element);
                        queue.offer(element);
                    }
                }
            }
            
            result++;
        }
    
        return 0;
    }
    
    Map<String, List<String>> constructAdjList(List<String> wordList){
        
        Map<String, List<String>> adjList = new HashMap<>();
        
        for(int i = 0; i < wordList.size(); i++){
            String currentWord = wordList.get(i);
            List<String> currList = adjList.getOrDefault(currentWord, new ArrayList<>());
            for(int j = 0; j < wordList.size(); j++){
                String neighborWord = wordList.get(j);
                if(!currentWord.equals(neighborWord) && oneCharAway(currentWord, neighborWord)){
                    currList.add(neighborWord);
                }
            }
            adjList.put(currentWord, currList);
        }
        
        return adjList;
    }
    
    boolean oneCharAway(String currentWord, String neighborWord){
        
        int matches = 0;
        char [] currentWordArray = currentWord.toCharArray(), neighborWordArray = neighborWord.toCharArray();
        
        for(int i = 0; i < currentWord.length(); i++){
            if(currentWordArray[i] == neighborWordArray[i]){
                matches++;
            }
        }
        
        return matches == currentWord.length() - 1;
    }
}
/**
hit -> hot
hot -> dot, lot, hit
dot -> dog, hot
dog -> cog, dot
**/


