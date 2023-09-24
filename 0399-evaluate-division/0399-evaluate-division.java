class Solution {
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Pair<String, Double>>> adjList = constructAdjList(equations, values);
        
        double [] result = new double[queries.size()];
        
        for(int index = 0; index < queries.size(); index++){
            
            List<String> query = queries.get(index);
            
            if(!adjList.containsKey(query.get(0)) || !adjList.containsKey(query.get(1))){
                result[index] = -1;
                continue;
            }
            
            result[index] = bfs(adjList, new Pair<>(query.get(0), 1.0), new HashSet<>(), query.get(1));
        }
        
        return result;
    }
    
    private double bfs(Map<String, List<Pair<String, Double>>> adjList, 
                       Pair<String, Double> node, Set<String> visited,
                       String destination){
        
         Queue<Pair<String, Double>> queue = new LinkedList<>();
         queue.offer(node);
        
         while(!queue.isEmpty()){
            
             Pair<String, Double> curr = queue.poll();
             
             visited.add(curr.getKey());
             
             if(curr.getKey().equals(destination)) return curr.getValue();
             
             for(Pair<String, Double> neighbor: adjList.get(curr.getKey())){
               if(!visited.contains(neighbor.getKey())){
                     queue.offer(new Pair<>(neighbor.getKey(), neighbor.getValue() * curr.getValue()));
               }
             }
         }
        
        return -1;
    }
    
    
    Map<String, List<Pair<String, Double>>> constructAdjList(List<List<String>> equations,
                                               double[] values){
        
        Map<String, List<Pair<String, Double>>> adjList = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++){
            
            String edge1 = equations.get(i).get(0), edge2 = equations.get(i).get(1);
            
            List<Pair<String, Double>> lst1 = adjList.getOrDefault(edge1, new ArrayList<>());
            List<Pair<String, Double>> lst2 = adjList.getOrDefault(edge2, new ArrayList<>());
            
            Pair<String, Double> pair1 = new Pair<>(edge2, values[i]);
            Pair<String, Double> pair2 = new Pair<>(edge1, 1 / values[i]);
            
            lst1.add(pair1);
            lst2.add(pair2);
            
            adjList.put(edge1, lst1);
            adjList.put(edge2, lst2);
        }
        
        return adjList;
    }
}