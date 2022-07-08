class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int result = Integer.MIN_VALUE;
        
        Map<Integer, List<Integer>> adjList = constructAdjList(n, roads);
        
        for(int i = 0; i < n; i++){
            
            for(int j = i + 1; j < n; j++){
                
                int sum = adjList.get(i).size() + adjList.get(j).size();
                
                if(adjList.get(j).contains(i)){
                    sum--;
                }
                
                result = Math.max(result, sum);
            }
        }
        
        return result;
    }
    
    Map<Integer, List<Integer>> constructAdjList(int n, int[][] roads){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < roads.length; i++){
            
            int edge1 = roads[i][0], edge2 = roads[i][1];
                
            List<Integer> lst1 = adjList.getOrDefault(edge1, new ArrayList<>());
            List<Integer> lst2 = adjList.getOrDefault(edge2, new ArrayList<>());
            
            lst1.add(edge2);
            lst2.add(edge1);
            
            adjList.put(edge1, lst1);
            adjList.put(edge2, lst2);
        }
        
        
        for(int i = 0; i < n; i++){
            if(!adjList.containsKey(i)){
                adjList.put(i, new ArrayList<>());
            }
        }
        return adjList;
    }
}