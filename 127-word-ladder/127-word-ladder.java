class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int [] level = new int[1];
        level[0] = 1;
        
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
            level[0] = 0;
        }
        
        Map<String, List<String>> adjList = constructAdjList(wordList);
        
        int result = 0;
        
       for(int j = 0; j < beginWord.length(); j++){
           
          String key = beginWord.substring(0, j) + "*" + beginWord.substring(j + 1);
           
          if(adjList.containsKey(key)){
              result = Math.max(result, bfs(adjList, beginWord, endWord));
          }
       }
        
        return result;
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
                
                for(int j = 0; j < currWord.length(); j++){

                    String key = currWord.substring(0, j) + "*" + currWord.substring(j + 1);
                    
                    if(adjList.containsKey(key)){
                        for(String element: adjList.get(key)){
                            if(!visited.contains(element)){
                                visited.add(element);
                                queue.offer(element);
                            }
                        }
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
            for(int j = 0; j < currentWord.length(); j++){
                String key = currentWord.substring(0, j) + "*" + currentWord.substring(j + 1);
                List<String> currList = adjList.getOrDefault(key, new ArrayList<>());
                currList.add(currentWord);
                adjList.put(key, currList);
            }
        }
        
        return adjList;
    }
}


