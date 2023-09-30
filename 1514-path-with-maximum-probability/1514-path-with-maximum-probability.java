class Solution {
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        Map<Integer, List<Pair<Integer, Double>>> adjList = buildAdjList(edges, succProb, n);
        
        PriorityQueue<Pair<Integer, Double>> queue = new PriorityQueue<Pair<Integer, Double>>((a, b) -> Double.compare(a.getValue(), b.getValue()));
        
        queue.offer(new Pair<Integer, Double>(start_node, -1.0));
        
        Set<Integer> visited = new HashSet<>();
        
        double [] distanceArr = new double[n];
        
        while(!queue.isEmpty()){
            
            Pair<Integer, Double> curr = queue.poll();
            
            visited.add(curr.getKey());
            
            distanceArr[curr.getKey()] = curr.getValue();
            
            if(curr.getKey() == end_node){
                return Math.abs(curr.getValue());
            }
            
            List<Pair<Integer, Double>> list = adjList.get(curr.getKey());
            
            for(Pair<Integer, Double> pair: list){
                
                double distance = -1.0 * Math.abs(pair.getValue() * curr.getValue());
                
                if(!visited.contains(pair.getKey()) || distance < distanceArr[pair.getKey()]){
                    queue.offer(new Pair<Integer, Double>(pair.getKey(), distance));
                }
            }
        }
        
        
        return 0;
    }
    
    Map<Integer, List<Pair<Integer, Double>>> buildAdjList(int[][] edges, double[] succProb, int n){
        
        Map<Integer, List<Pair<Integer, Double>>> adjList = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(int index = 0; index < edges.length; index++){
            int [] edge = edges[index];
            adjList.get(edge[0]).add(new Pair<Integer, Double>(edge[1], succProb[index]));
            adjList.get(edge[1]).add(new Pair<Integer, Double>(edge[0], succProb[index]));
        }
        
        return adjList;
    }
}