class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(graph.length == 0){
            return result;
        }
        
        List<Integer> currList = new ArrayList<>();
        currList.add(0);
        
        allPathsSourceTarget(graph, graph[0], currList, result, -1);
        
        return result;
    }
    
    private void allPathsSourceTarget(int[][] graph,
                                      int [] currGraph,
                                      List<Integer> currList, 
                                      List<List<Integer>> result,
                                      int element){
        
        if(element == graph.length - 1){
            result.add(new ArrayList<>(currList));
            return;
        }
      
        for(int i = 0; i < currGraph.length; i++){    
            int currElement = currGraph[i];
            currList.add(currElement);
            allPathsSourceTarget(graph, graph[currElement], currList, result, currElement);
            currList.remove(currList.size() - 1);
        }
    }
}